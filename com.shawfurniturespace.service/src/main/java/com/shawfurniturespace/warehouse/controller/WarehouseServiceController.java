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

import com.shawfurniturespace.warehouse.dto.WarehousesRequestDto;
import com.shawfurniturespace.warehouse.exception.WareHouseException;
import com.shawfurniturespace.warehouse.model.Warehouses;
import com.shawfurniturespace.warehouse.service.WarehousesService;
/**
 * Controller for Handling CRUD operation for warehouse 
 */
@RestController
@RequestMapping("/warehouses")
@CrossOrigin(origins = {"http://localhost:4200"})
@Transactional
public class WarehouseServiceController {
	
	@Autowired
	WarehousesService warehouseService;
	
	

	/**
	 * Get all the data from warehouse table 
	 * @return
	 * @throws WareHouseException
	 */
	@GetMapping("/all")
	public ResponseEntity<List<Warehouses>> getAllWarehouses() throws WareHouseException{
		List<Warehouses> allWarehousesList = new ArrayList<>();
		allWarehousesList = warehouseService.getAllWarehouses();
		return new ResponseEntity<List<Warehouses>>(allWarehousesList, HttpStatus.OK);
		 
	}
	
	/** 
	 * delete warehouse by id 
	 * @param id
	 * @throws WareHouseException
	 */
	@DeleteMapping("/id/{id}")
	public void deleteWarehouseById(@PathVariable Integer id) throws WareHouseException{
		warehouseService.deleteWarehouse(id);
		 
	}
	
	/**
	 * Save the Warehouse data 
	 * @param WarehousesRequestdto
	 * @return
	 * @throws WareHouseException
	 */
	@PostMapping("/store")
	public ResponseEntity<Warehouses> storeWarehouses(@RequestBody WarehousesRequestDto WarehousesRequestdto) throws WareHouseException{
		Warehouses saveWarehouses = null;
		saveWarehouses = warehouseService.saveWarehouse(WarehousesRequestdto);
		return new ResponseEntity<>(saveWarehouses, HttpStatus.OK);
		 
	}
	/**
	 * Update the warehouse data
	 * @param WarehousesRequestdto
	 * @return
	 * @throws WareHouseException
	 */
	@PutMapping("/update")
	public ResponseEntity<Warehouses> updateWarehouse(@RequestBody WarehousesRequestDto WarehousesRequestdto) throws WareHouseException{
		Warehouses savewarehouse = null;
		savewarehouse = warehouseService.updateWarehouse(WarehousesRequestdto);
		return new ResponseEntity<>(savewarehouse, HttpStatus.OK);
		 
	}

}
