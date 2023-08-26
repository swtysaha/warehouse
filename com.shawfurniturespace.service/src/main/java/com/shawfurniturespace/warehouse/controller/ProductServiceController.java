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
import com.shawfurniturespace.warehouse.exception.WareHouseException;
import com.shawfurniturespace.warehouse.model.Product;
import com.shawfurniturespace.warehouse.service.ProductService;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = {"http://localhost:4200"})
@Transactional
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
	public ResponseEntity<Product> storeProduct(@RequestBody ProductRequestDto productRequestdto){
		Product saveProduct = null;
		try {
			 saveProduct = productService.saveProduct(productRequestdto);
			
		} catch (WareHouseException e) {
			saveProduct = new Product();
			saveProduct.setDescription(e.getMessage());
			return new ResponseEntity<>(saveProduct, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(saveProduct, HttpStatus.OK);
		 
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable Integer id){
		
		try {
			productService.deleteProduct(id);
		} catch (WareHouseException e) {
			return new ResponseEntity<String>("Deleted Unsuccessfully", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
		 
	}
	
	@PutMapping("/update")
	public ResponseEntity<Product> updateProduct(@RequestBody ProductRequestDto productRequestdto){
		Product saveProduct = null;
		try {
			 saveProduct = productService.updateProduct(productRequestdto);
			
		} catch (WareHouseException e) {
			saveProduct = new Product();
			saveProduct.setDescription(e.getMessage());
			return new ResponseEntity<>(saveProduct, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(saveProduct, HttpStatus.OK);
		 
	}
}
