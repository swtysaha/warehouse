package com.shawfurniturespace.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shawfurniturespace.warehouse.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
