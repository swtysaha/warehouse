package com.shawfurniturespace.warehouse.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shawfurniturespace.warehouse.dto.OrderRequestDto;
import com.shawfurniturespace.warehouse.exception.WareHouseException;
import com.shawfurniturespace.warehouse.model.Order;
import com.shawfurniturespace.warehouse.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderServiceController {
	
	@Autowired
	OrderService orderService;
	
	
	@GetMapping("/customerId/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable Integer id){
		Order Order;
		try {
			Order = orderService.getOrderByCustomerId(id);
			
		} catch (WareHouseException e) {
			Order =  null;
		}
		return new ResponseEntity<Order>(Order, HttpStatus.OK);
		 
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Order>> getAllOrders(){
		List<Order> allOrderList = new ArrayList<>();
		try {
			allOrderList = orderService.getAllOrders();
		} catch (WareHouseException e) {
			
		}
		return new ResponseEntity<List<Order>>(allOrderList, HttpStatus.OK);
		 
	}
	
	@PostMapping("/store")
	public ResponseEntity<String> storeOrder(@RequestBody OrderRequestDto OrderRequestdto){
		String generatedprodId = null;
		try {
			Order saveOrder = orderService.saveOrder(OrderRequestdto);
			generatedprodId = String.valueOf(saveOrder.getOrderId());
		} catch (WareHouseException e) {
			
		}
		return new ResponseEntity<>(generatedprodId, HttpStatus.OK);
		 
	}
}
