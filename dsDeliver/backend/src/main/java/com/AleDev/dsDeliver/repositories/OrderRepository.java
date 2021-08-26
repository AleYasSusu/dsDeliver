package com.AleDev.dsDeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AleDev.dsDeliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
