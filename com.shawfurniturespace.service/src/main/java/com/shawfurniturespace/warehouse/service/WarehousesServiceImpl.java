package com.shawfurniturespace.warehouse.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shawfurniturespace.warehouse.dto.WarehousesRequestDto;
import com.shawfurniturespace.warehouse.exception.WareHouseException;
import com.shawfurniturespace.warehouse.model.Warehouses;
import com.shawfurniturespace.warehouse.repository.WarehouseRepository;

@Service
public class WarehousesServiceImpl implements WarehousesService {

	@Autowired
	private WarehouseRepository warehouseRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Warehouses> getAllWarehouses() throws WareHouseException {
		List<Warehouses> allWarehouses = warehouseRepository.findAll();
		return allWarehouses;
	}

	@Override
	public Warehouses saveWarehouse(WarehousesRequestDto warehouseDto) throws WareHouseException {
		Warehouses prodcutMap = mapper.map(warehouseDto, Warehouses.class);
		if(warehouseDto.getAvailableSpace() != warehouseDto.getCapacity()) {
			throw new WareHouseException("Capacity and Availability should be same");
		}
		return warehouseRepository.save(prodcutMap);
	}
	
	@Override
	public Warehouses updateWarehouse(WarehousesRequestDto warehouseDto) throws WareHouseException {
		Warehouses prodcutMap = mapper.map(warehouseDto, Warehouses.class);
		return warehouseRepository.save(prodcutMap);
	}

	@Override
	public void deleteWarehouse(Integer id) throws WareHouseException {
		// TODO Auto-generated method stub
		warehouseRepository.deleteById(id);
		
	}


}
