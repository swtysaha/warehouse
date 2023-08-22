package com.shawfurniturespace.warehouse.service;

import java.util.List;

import com.shawfurniturespace.warehouse.controller.ProductRequestDto;
import com.shawfurniturespace.warehouse.exception.WareHouseException;
import com.shawfurniturespace.warehouse.model.Product;


public interface ProductService {


	public List<Product> getAllProducts() throws WareHouseException;

	public Product getProductById(int prodId) throws WareHouseException;

	public Product saveProduct(ProductRequestDto productDto) throws WareHouseException;
}
