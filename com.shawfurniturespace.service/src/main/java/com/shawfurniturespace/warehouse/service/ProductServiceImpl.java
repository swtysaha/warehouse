package com.shawfurniturespace.warehouse.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shawfurniturespace.warehouse.ApplicationConfiguration;
import com.shawfurniturespace.warehouse.controller.ProductRequestDto;
import com.shawfurniturespace.warehouse.exception.WareHouseException;
import com.shawfurniturespace.warehouse.model.Product;
import com.shawfurniturespace.warehouse.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public List<Product> getAllProducts() throws WareHouseException{
		List<Product> allProducts = productRepository.findAll();
		return allProducts;
	}
	
	@Override
	public Product getProductById(int prodId) throws WareHouseException {
		Optional<Product> productFromDB = productRepository.findById(prodId);
		if(productFromDB.isEmpty()) {
			throw new WareHouseException("No product present");
		}
		return productFromDB.get();
	}
	
	@Override
	public Product saveProduct(ProductRequestDto productDto)throws WareHouseException {
		Product prodcutMap = mapper.map(productDto, Product.class);
		return productRepository.save(prodcutMap);
	}
}
