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

import com.shawfurniturespace.warehouse.dto.SupplierRequestDto;
import com.shawfurniturespace.warehouse.exception.WareHouseException;
import com.shawfurniturespace.warehouse.model.Supplier;
import com.shawfurniturespace.warehouse.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierServiceController {
	
	@Autowired
	SupplierService supplierService;
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Supplier> getSupplierById(@PathVariable Integer id){
		Supplier Supplier;
		try {
			Supplier = supplierService.getSupplierById(id);
			
		} catch (WareHouseException e) {
			Supplier =  null;
		}
		return new ResponseEntity<Supplier>(Supplier, HttpStatus.OK);
		 
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Supplier>> getAllSuppliers(){
		List<Supplier> allSupplierList = new ArrayList<>();
		try {
			allSupplierList = supplierService.getAllSuppliers();
		} catch (WareHouseException e) {
			
		}
		return new ResponseEntity<List<Supplier>>(allSupplierList, HttpStatus.OK);
		 
	}
	
	@PostMapping("/store")
	public ResponseEntity<String> storeSupplier(@RequestBody SupplierRequestDto SupplierRequestdto){
		String generatedprodId = null;
		try {
			Supplier saveSupplier = supplierService.saveSupplier(SupplierRequestdto);
			generatedprodId = String.valueOf(saveSupplier.getSupplierId());
		} catch (WareHouseException e) {
			
		}
		return new ResponseEntity<>(generatedprodId, HttpStatus.OK);
		 
	}
}
