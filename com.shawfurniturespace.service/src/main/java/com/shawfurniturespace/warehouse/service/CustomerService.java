package com.shawfurniturespace.warehouse.service;

import java.util.List;

import com.shawfurniturespace.warehouse.dto.CustomerRequestDto;
import com.shawfurniturespace.warehouse.exception.WareHouseException;
import com.shawfurniturespace.warehouse.model.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomer() throws WareHouseException;

	//it should be GetCustomerByMobile...that should be unique noone will remember the id
	public Customer getCustomerById(int categoryId) throws WareHouseException;

	public Customer saveCustomer(CustomerRequestDto customerDto) throws WareHouseException;

}
