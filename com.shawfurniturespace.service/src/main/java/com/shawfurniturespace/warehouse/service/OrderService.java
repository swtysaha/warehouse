package com.shawfurniturespace.warehouse.service;

import java.util.List;

import com.shawfurniturespace.warehouse.dto.OrderRequestDto;
import com.shawfurniturespace.warehouse.exception.WareHouseException;
import com.shawfurniturespace.warehouse.model.Order;


public interface OrderService {


	public List<Order> getAllOrders() throws WareHouseException;

	public Order getOrderByCustomerId(int custid) throws WareHouseException;

	public Order saveOrder(OrderRequestDto orderDto) throws WareHouseException;
}
