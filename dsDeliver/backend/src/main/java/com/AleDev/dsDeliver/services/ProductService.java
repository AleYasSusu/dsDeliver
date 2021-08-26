package com.AleDev.dsDeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.AleDev.dsDeliver.dto.ProductDto;
import com.AleDev.dsDeliver.entities.Product;
import com.AleDev.dsDeliver.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Transactional(readOnly = true)
	public List<ProductDto> findAll() {
		List<Product> list = productRepository.findAllByOrderByNameAsc();
		return list.stream().map(x -> new ProductDto(x)).collect(Collectors.toList());
	}

}
