package com.shawfurniturespace.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.shawfurniturespace.warehouse.model.Warehouses;

public interface WarehouseRepository extends JpaRepository<Warehouses, Integer> {
	

}
