package com.AleDev.dsDeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.AleDev.dsDeliver.dto.OrderDto;
import com.AleDev.dsDeliver.entities.Order;
import com.AleDev.dsDeliver.repositories.OrderRepository;
@Service
public class OrderService {


	@Autowired
	private OrderRepository orderRepository;

	@Transactional(readOnly = true)
	public List<OrderDto> findAll() {
		List<Order> list = orderRepository.findOrderWithProducts();
		return list.stream().map(x -> new OrderDto(x)).collect(Collectors.toList());
	}

}

