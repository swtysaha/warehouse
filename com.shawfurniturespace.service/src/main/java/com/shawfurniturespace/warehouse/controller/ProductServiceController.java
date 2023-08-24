package com.shawfurniturespace.warehouse.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.shawfurniturespace.warehouse.dto.ProductRequestDto;
import com.shawfurniturespace.warehouse.exception.WareHouseException;
import com.shawfurniturespace.warehouse.model.Product;
import com.shawfurniturespace.warehouse.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductServiceController {
	
	@Autowired
	ProductService productService;
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer id){
		Product product;
		try {
			product = productService.getProductById(id);
			
		} catch (WareHouseException e) {
			product =  null;
		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);
		 
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> allProductList = new ArrayList<>();
		try {
			allProductList = productService.getAllProducts();
		} catch (WareHouseException e) {
			
		}
		return new ResponseEntity<List<Product>>(allProductList, HttpStatus.OK);
		 
	}
	
	@PostMapping("/store")
	public ResponseEntity<String> storeProduct(@RequestBody ProductRequestDto productRequestdto){
		String generatedprodId = null;
		try {
			Product saveProduct = productService.saveProduct(productRequestdto);
			generatedprodId = String.valueOf(saveProduct.getProductId());
		} catch (WareHouseException e) {
			
		}
		return new ResponseEntity<>(generatedprodId, HttpStatus.OK);
		 
	}
}
