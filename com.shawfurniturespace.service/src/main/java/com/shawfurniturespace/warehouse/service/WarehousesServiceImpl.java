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
	
	/**
	 * Update warehouse data  
	 */
	@Override
	public Warehouses updateWarehouse(WarehousesRequestDto warehouseDto) throws WareHouseException {
		
		Optional<Warehouses> warehouseObj = warehouseRepository.findById(warehouseDto.getId());
		if (warehouseObj.isPresent()) {
			Warehouses objToUpdate = warehouseObj.get();

			int previousCapacity = objToUpdate.getCapacity();
			int currentCapacity = warehouseDto.getCapacity();
			int previousAvailableSpace = objToUpdate.getAvailableSpace();
			
			int diffCapacity = currentCapacity - previousCapacity;
			

			if (diffCapacity>=0) {
				int finalAvl = previousAvailableSpace+diffCapacity;
				objToUpdate.setCapacity(previousCapacity+diffCapacity);
				if (finalAvl<=objToUpdate.getCapacity()) {
				objToUpdate.setAvailableSpace(finalAvl);
				}else {
					throw new WareHouseException("Availability cannot be more than capacity");
				}
			}else {
				throw new WareHouseException("Cannot decrease the capacity");
			}
			
			return warehouseRepository.save(objToUpdate);
		}else {
			throw new WareHouseException("Warehouse could not be found");
		}
	}
			

			

	@Override
	public void deleteWarehouse(Integer id) throws WareHouseException {
		warehouseRepository.deleteById(id);
				
	}


}
