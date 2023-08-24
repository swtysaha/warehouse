package com.shawfurniturespace.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shawfurniturespace.warehouse.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>  {

}
