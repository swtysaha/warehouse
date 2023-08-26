package com.shawfurniturespace.warehouse.service;

import java.util.List;

import com.shawfurniturespace.warehouse.dto.ProductRequestDto;
import com.shawfurniturespace.warehouse.exception.WareHouseException;
import com.shawfurniturespace.warehouse.model.Product;


public interface ProductService {


	public List<Product> getAllProducts() throws WareHouseException;

	public Product getProductById(int prodId) throws WareHouseException;

	public void deleteProduct(Integer id) throws WareHouseException;
	
	public Product updateProduct(ProductRequestDto productDto) throws WareHouseException;
	
	public Product saveProduct(ProductRequestDto productDto) throws WareHouseException;
	
}
