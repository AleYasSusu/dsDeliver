package com.AleDev.dsDeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.AleDev.dsDeliver.dto.OrderDto;
import com.AleDev.dsDeliver.dto.ProductDto;
import com.AleDev.dsDeliver.entities.Order;
import com.AleDev.dsDeliver.entities.OrderStatus;
import com.AleDev.dsDeliver.entities.Product;
import com.AleDev.dsDeliver.repositories.OrderRepository;
import com.AleDev.dsDeliver.repositories.ProductRepository;
@Service
public class OrderService {


	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ProductRepository  productRepository;

	@Transactional(readOnly = true)
	public List<OrderDto> findAll() {
		List<Order> list = orderRepository.findOrderWithProducts();
		return list.stream().map(x -> new OrderDto(x)).collect(Collectors.toList());
	}

	@Transactional
	public OrderDto insert(OrderDto dto) {
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), Instant.now(), OrderStatus.PENDING);
		for(ProductDto p : dto.getProducts()) {
			Product products = productRepository.getOne(p.getId());
			order.getProducts().add(products);
		}
		order = orderRepository.save(order);
		return new OrderDto(order);
	}
	
}

