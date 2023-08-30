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

/**
 * Controller for Handling CRUD operation for products 
 */
@RestController
@RequestMapping("/product")
@CrossOrigin(origins = {"http://localhost:4200"})
@Transactional

public class ProductServiceController {
	
	@Autowired
	ProductService productService;
	
	/**
	 * Get Product by id
	 * @param id
	 * @return
	 */
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
	/**
	 * Get All products
	 * @return
	 * @throws WareHouseException
	 */
	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProduct() throws WareHouseException{
		List<Product> allProductList = new ArrayList<>();
		allProductList = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(allProductList, HttpStatus.OK);
		 
	}
	/**
	 * Save the product details in database
	 * @param productRequestdto
	 * @return
	 * @throws WareHouseException
	 */
	@PostMapping("/store")
	public ResponseEntity<Product> storeProduct(@RequestBody ProductRequestDto productRequestdto) throws WareHouseException{
		Product saveProduct = productService.saveProduct(productRequestdto);
		return new ResponseEntity<>(saveProduct, HttpStatus.OK);
		 
	}
	/**
	 * Delete Product from id
	 * @param id
	 * @throws WareHouseException
	 */
	@DeleteMapping("/id/{id}")
	public void deleteProductById(@PathVariable Integer id) throws WareHouseException{
		productService.deleteProduct(id);
		 
	}
	/**
	 * Update the product details 
	 * @param productRequestdto
	 * @return
	 * @throws WareHouseException
	 */
	
	@PutMapping("/update")
	public ResponseEntity<Product> updateProduct(@RequestBody ProductRequestDto productRequestdto) throws WareHouseException{
		Product saveProduct = productService.updateProduct(productRequestdto);
		return new ResponseEntity<>(saveProduct, HttpStatus.OK);
		 
	}
}
