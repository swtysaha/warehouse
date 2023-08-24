package com.shawfurniturespace.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shawfurniturespace.warehouse.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>  {

}
