package com.AleDev.dsDeliver.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AleDev.dsDeliver.dto.ProductDto;
import com.AleDev.dsDeliver.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductControl {

	
	@Autowired
	private ProductService productService;
	
	
	
	@GetMapping
	public ResponseEntity<List<ProductDto>> findAll(){
	List<ProductDto> list = productService.findAll();
	return ResponseEntity.ok().body(list);
	}
}
