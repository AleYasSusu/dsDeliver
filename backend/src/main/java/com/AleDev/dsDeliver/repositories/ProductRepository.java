package com.AleDev.dsDeliver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AleDev.dsDeliver.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findAllByOrderByNameAsc();
	
}
