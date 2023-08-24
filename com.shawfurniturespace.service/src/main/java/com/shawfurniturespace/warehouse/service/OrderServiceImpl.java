package com.shawfurniturespace.warehouse.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shawfurniturespace.warehouse.dto.OrderRequestDto;
import com.shawfurniturespace.warehouse.exception.WareHouseException;
import com.shawfurniturespace.warehouse.model.Order;
import com.shawfurniturespace.warehouse.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public List<Order> getAllOrders() throws WareHouseException{
		List<Order> allOrders = orderRepository.findAll();
		return allOrders;
	}
	
	@Override
	public Order getOrderByCustomerId(int prodId) throws WareHouseException {
		Optional<Order> OrderFromDB = orderRepository.findById(prodId);
		if(OrderFromDB.isEmpty()) {
			throw new WareHouseException("No Order present");
		}
		return OrderFromDB.get();
	}
	
	@Override
	public Order saveOrder(OrderRequestDto OrderDto)throws WareHouseException {
		Order prodcutMap = mapper.map(OrderDto, Order.class);
		return orderRepository.save(prodcutMap);
	}
}
