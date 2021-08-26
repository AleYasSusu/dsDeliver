package com.AleDev.dsDeliver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AleDev.dsDeliver.dto.OrderDto;
import com.AleDev.dsDeliver.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderControl {
	@Autowired
	private OrderService orderService;
	
	
	
	@GetMapping
	public ResponseEntity<List<OrderDto>> findAll(){
	List<OrderDto> list = orderService.findAll();
	return ResponseEntity.ok().body(list);
	}
}
