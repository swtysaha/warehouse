package com.shawfurniturespace.warehouse.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shawfurniturespace.warehouse.dto.CategoryRequestDto;
import com.shawfurniturespace.warehouse.exception.WareHouseException;
import com.shawfurniturespace.warehouse.model.Category;
import com.shawfurniturespace.warehouse.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ModelMapper categoryMapper;
	
	@Override
	public List<Category> getAllCategories() throws WareHouseException {
		List<Category> allCategories = categoryRepository.findAll();
		return allCategories;
	}

	@Override
	public Category getCategoryById(int categoryId) throws WareHouseException {
		Optional<Category> categoryFromDB = categoryRepository.findById(categoryId);
		if(categoryFromDB.isEmpty()) {
			throw new WareHouseException("No Category present");
		}
		return categoryFromDB.get();
	}

	@Override
	public Category saveCategory(CategoryRequestDto categoryDto) throws WareHouseException {
		Category categoryMap = categoryMapper.map(categoryDto, Category.class);
		return categoryRepository.save(categoryMap);
	}

}
