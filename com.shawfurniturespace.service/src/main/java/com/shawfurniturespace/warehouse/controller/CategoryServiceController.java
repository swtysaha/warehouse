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

import com.shawfurniturespace.warehouse.dto.CategoryRequestDto;
import com.shawfurniturespace.warehouse.exception.WareHouseException;
import com.shawfurniturespace.warehouse.model.Category;
import com.shawfurniturespace.warehouse.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryServiceController {
	
	@Autowired
	CategoryService categoryService;
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Integer id){
		Category category;
		try {
			category = categoryService.getCategoryById(id);
			
		} catch (WareHouseException e) {
			category =  null;
		}
		return new ResponseEntity<Category>(category, HttpStatus.OK);
		 
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Category>> getAllCategory(){
		List<Category> allCategoryList = new ArrayList<>();
		try {
			allCategoryList = categoryService.getAllCategories();
		} catch (WareHouseException e) {
			
		}
		return new ResponseEntity<List<Category>>(allCategoryList, HttpStatus.OK);
		 
	}
	
	@PostMapping("/store")
	public ResponseEntity<String> storeCategory(@RequestBody CategoryRequestDto CategoryRequestdto){
		String generatedprodId = null;
		try {
			Category saveCategory = categoryService.saveCategory(CategoryRequestdto);
			generatedprodId = String.valueOf(saveCategory.getCategoryId());
		} catch (WareHouseException e) {
			
		}
		return new ResponseEntity<>(generatedprodId, HttpStatus.OK);
		 
	}
}
