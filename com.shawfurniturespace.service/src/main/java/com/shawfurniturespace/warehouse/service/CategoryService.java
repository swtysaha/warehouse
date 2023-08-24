package com.shawfurniturespace.warehouse.service;

import java.util.List;

import com.shawfurniturespace.warehouse.dto.CategoryRequestDto;
import com.shawfurniturespace.warehouse.exception.WareHouseException;
import com.shawfurniturespace.warehouse.model.Category;


public interface CategoryService {


	public List<Category> getAllCategories() throws WareHouseException;

	public Category getCategoryById(int categoryId) throws WareHouseException;

	public Category saveCategory(CategoryRequestDto categoryDto) throws WareHouseException;
}
