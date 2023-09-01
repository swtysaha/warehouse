package com.shawfurniturespace.warehouse.service;

import java.util.List;

import com.shawfurniturespace.warehouse.dto.WarehousesRequestDto;
import com.shawfurniturespace.warehouse.exception.WareHouseException;
import com.shawfurniturespace.warehouse.model.Warehouses;

public interface WarehousesService {

	public List<Warehouses> getAllWarehouses() throws WareHouseException;

	public void deleteWarehouse(Integer id) throws WareHouseException;

	public Warehouses saveWarehouse(WarehousesRequestDto warehouseDto) throws WareHouseException;
	
	public Warehouses updateWarehouse(WarehousesRequestDto warehouseDto) throws WareHouseException;
	
}
