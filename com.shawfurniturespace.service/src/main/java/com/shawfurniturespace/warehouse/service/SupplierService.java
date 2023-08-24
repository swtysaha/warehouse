package com.shawfurniturespace.warehouse.service;

import java.util.List;

import com.shawfurniturespace.warehouse.dto.SupplierRequestDto;
import com.shawfurniturespace.warehouse.exception.WareHouseException;
import com.shawfurniturespace.warehouse.model.Supplier;


public interface SupplierService {


	public List<Supplier> getAllSuppliers() throws WareHouseException;

	public Supplier getSupplierById(int prodId) throws WareHouseException;

	public Supplier saveSupplier(SupplierRequestDto SupplierDto) throws WareHouseException;
}
