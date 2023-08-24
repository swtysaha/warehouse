package com.shawfurniturespace.warehouse.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shawfurniturespace.warehouse.dto.SupplierRequestDto;
import com.shawfurniturespace.warehouse.exception.WareHouseException;
import com.shawfurniturespace.warehouse.model.Supplier;
import com.shawfurniturespace.warehouse.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public List<Supplier> getAllSuppliers() throws WareHouseException{
		List<Supplier> allSuppliers = supplierRepository.findAll();
		return allSuppliers;
	}
	
	@Override
	public Supplier getSupplierById(int prodId) throws WareHouseException {
		Optional<Supplier> SupplierFromDB = supplierRepository.findById(prodId);
		if(SupplierFromDB.isEmpty()) {
			throw new WareHouseException("No Supplier present");
		}
		return SupplierFromDB.get();
	}
	
	@Override
	public Supplier saveSupplier(SupplierRequestDto SupplierDto)throws WareHouseException {
		Supplier prodcutMap = mapper.map(SupplierDto, Supplier.class);
		return supplierRepository.save(prodcutMap);
	}
}
