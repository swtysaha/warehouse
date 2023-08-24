package com.shawfurniturespace.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shawfurniturespace.warehouse.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
