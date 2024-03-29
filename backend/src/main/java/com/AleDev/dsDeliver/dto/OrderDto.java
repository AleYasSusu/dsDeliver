package com.AleDev.dsDeliver.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.AleDev.dsDeliver.entities.Order;
import com.AleDev.dsDeliver.entities.OrderStatus;

public class OrderDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String address;
	private Double latitude;
	private Double longitude;
	private Instant moment;
	private OrderStatus status;
	
	private List<ProductDto> products = new ArrayList<>();
	
	
	
	
	
	public OrderDto() {
		
	}
	public OrderDto(Long id, String address, Double latitude, Double longitude, Instant moment, OrderStatus status) {
		
		this.id = id;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.moment = moment;
		this.status = status;
	}
	
	
	public OrderDto(Order ord) {
		
		id = ord.getId();
		address = ord.getAddress();
		latitude = ord.getLatitude();
		longitude = ord.getLongitude();
		moment = ord.getMoment();
		status = ord.getStatus();
		products = ord.getProducts().stream().map(x -> new ProductDto(x)).collect(Collectors.toList());
	}
	public List<ProductDto> getProducts() {
		return products;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Instant getMoment() {
		return moment;
	}
	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	};

	
	
}
