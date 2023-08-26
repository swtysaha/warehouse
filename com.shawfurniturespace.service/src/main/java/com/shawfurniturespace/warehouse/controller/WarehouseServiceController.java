package com.shawfurniturespace.warehouse.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shawfurniturespace.warehouse.dto.ProductRequestDto;
import com.shawfurniturespace.warehouse.dto.WarehousesRequestDto;
import com.shawfurniturespace.warehouse.exception.WareHouseException;
import com.shawfurniturespace.warehouse.model.Product;
import com.shawfurniturespace.warehouse.model.Warehouses;
import com.shawfurniturespace.warehouse.service.WarehousesService;

@RestController
@RequestMapping("/warehouses")
@CrossOrigin(origins = {"http://localhost:4200"})
@Transactional
public class WarehouseServiceController {
	
	@Autowired
	WarehousesService warehouseService;
	
	

	
	@GetMapping("/all")
	public ResponseEntity<List<Warehouses>> getAllWarehouses(){
		List<Warehouses> allWarehousesList = new ArrayList<>();
		try {
			allWarehousesList = warehouseService.getAllWarehouses();
		} catch (WareHouseException e) {
			
		}
		return new ResponseEntity<List<Warehouses>>(allWarehousesList, HttpStatus.OK);
		 
	}
	@DeleteMapping("/id/{id}")
	public ResponseEntity<String> deleteWarehouseById(@PathVariable Integer id){
		
		try {
			 warehouseService.deleteWarehouse(id);
		} catch (WareHouseException e) {
			return new ResponseEntity<String>("Deleted Unsuccessfully", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
		 
	}
	
	
	@PostMapping("/store")
	public ResponseEntity<Warehouses> storeWarehouses(@RequestBody WarehousesRequestDto WarehousesRequestdto) throws WareHouseException{
		Warehouses saveWarehouses = null;
		saveWarehouses = warehouseService.saveWarehouse(WarehousesRequestdto);
		return new ResponseEntity<>(saveWarehouses, HttpStatus.OK);
		 
	}
	
	@PutMapping("/update")
	public ResponseEntity<Warehouses> updateWarehouse(@RequestBody WarehousesRequestDto WarehousesRequestdto){
		Warehouses savewarehouse = null;
		try {
			 savewarehouse = warehouseService.updateWarehouse(WarehousesRequestdto);
			
		} catch (WareHouseException e) {
			savewarehouse = new Warehouses();
			return new ResponseEntity<>(savewarehouse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(savewarehouse, HttpStatus.OK);
		 
	}

}
