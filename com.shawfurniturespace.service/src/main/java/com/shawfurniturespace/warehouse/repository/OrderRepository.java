package com.shawfurniturespace.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shawfurniturespace.warehouse.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
}
