package com.shawfurniturespace.warehouse.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shawfurniturespace.warehouse.dto.ProductRequestDto;
import com.shawfurniturespace.warehouse.exception.WareHouseException;
import com.shawfurniturespace.warehouse.model.Product;
import com.shawfurniturespace.warehouse.model.Warehouses;
import com.shawfurniturespace.warehouse.repository.ProductRepository;
import com.shawfurniturespace.warehouse.repository.WarehouseRepository;

/**
 * 
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private WarehouseRepository warehouseRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Product> getAllProducts() throws WareHouseException {
		List<Product> allProducts = productRepository.findAll();
		return allProducts;
	}

	@Override
	public Product getProductById(int prodId) throws WareHouseException {
		Optional<Product> productFromDB = productRepository.findById(prodId);
		if (productFromDB.isEmpty()) {
			throw new WareHouseException("No product present");
		}
		return productFromDB.get();
	}

	@Transactional
	@Override
	public Product saveProduct(ProductRequestDto productDto) throws WareHouseException {

		Product prodcutMap = mapper.map(productDto, Product.class);
		Optional<Warehouses> warehouseObj = warehouseRepository.findById(productDto.getWarehouseId());

		if (warehouseObj.isPresent()) {
			Warehouses objToUpdate = warehouseObj.get();

			if (objToUpdate.getAvailableSpace() == productDto.getQuantity()
					|| objToUpdate.getAvailableSpace() > productDto.getQuantity()) {

				int availableSpace = (objToUpdate.getCapacity()) - (productDto.getQuantity());
				objToUpdate.setAvailableSpace(availableSpace);

				Product savedProduct = productRepository.save(prodcutMap);
				Warehouses saveWr = warehouseRepository.save(objToUpdate);
				savedProduct.setWarehouseId(saveWr);
				return savedProduct;

			} else {
				throw new WareHouseException("No space availbale in warehouse");
			}
		} else {
			throw new WareHouseException("Warehouse could not be found");
		}

	}

	@Override
	public void deleteProduct(Integer id) throws WareHouseException {
		Optional<Product> productOpt = productRepository.findById(id);
		if (productOpt.isPresent()) {
			Product product = productOpt.get();
			productRepository.deleteById(id);
			Optional<Warehouses> wrOpt = warehouseRepository.findById(product.getWarehouseId().getId());
			if (wrOpt.isPresent()) {
				Warehouses wrToUpdate = wrOpt.get();
				wrToUpdate.setAvailableSpace(wrToUpdate.getAvailableSpace() + product.getQuantity());
				warehouseRepository.save(wrToUpdate);
			}

		}

	}

	/**
	 * 
	 */
	@Override
	public Product updateProduct(ProductRequestDto productDto) throws WareHouseException {
		Product prodcutMap = mapper.map(productDto, Product.class);
		Optional<Warehouses> warehouseObj = warehouseRepository.findById(productDto.getWarehouseId());

		if (warehouseObj.isPresent()) {
			Warehouses objToUpdate = warehouseObj.get();
			Optional<Product> productFound = productRepository.findById(productDto.getProductId());
			if (productFound.isPresent()) {
				Product product = productFound.get();
				int previousQuantity = product.getQuantity();
				int currentQuantity = productDto.getQuantity();
				// increasin in quantity so decrease in avail
				int finalAvail = currentQuantity;
				if (currentQuantity > previousQuantity) {
					finalAvail = objToUpdate.getAvailableSpace() - (currentQuantity - previousQuantity);

				} else if (currentQuantity < previousQuantity) {
					// decrease in quantity so increase in avail
					finalAvail = objToUpdate.getAvailableSpace() + (previousQuantity - currentQuantity);
				}

				// Check if finalAvail is less than capacity then allow the update or else
				// throw error
				if (finalAvail>=0 && finalAvail <= objToUpdate.getCapacity()) {

					objToUpdate.setAvailableSpace(finalAvail);
					Product savedProduct = productRepository.save(prodcutMap);
					Warehouses saveWr = warehouseRepository.save(objToUpdate);
					savedProduct.setWarehouseId(saveWr);
					return savedProduct;

				} else {
					throw new WareHouseException("No space availbale in warehouse");
				}
			}else {
				throw new WareHouseException("Product could not be found");
			}
		} else {
			throw new WareHouseException("Warehouse could not be found");
		}

		
	}

}
