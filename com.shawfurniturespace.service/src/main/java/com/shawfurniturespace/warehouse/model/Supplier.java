package com.shawfurniturespace.warehouse.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="supplier_id")
	private Integer supplierId;
	
	@Column(name = "supplier_name")
	private String supplierName	;
	
	@Column(name = "supplier_email")
	private String supplierEmail;
	
	@Column(name = "supplier_mobile")
	private String supplierMobile;

	/**
	 * @return the supplierId
	 */
	public Integer getSupplierId() {
		return supplierId;
	}

	/**
	 * @param supplierId the supplierId to set
	 */
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	/**
	 * @return the supplierName
	 */
	public String getSupplierName() {
		return supplierName;
	}

	/**
	 * @param supplierName the supplierName to set
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	/**
	 * @return the supplierEmail
	 */
	public String getSupplierEmail() {
		return supplierEmail;
	}

	/**
	 * @param supplierEmail the supplierEmail to set
	 */
	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}

	/**
	 * @return the supplierMobile
	 */
	public String getSupplierMobile() {
		return supplierMobile;
	}

	/**
	 * @param supplierMobile the supplierMobile to set
	 */
	public void setSupplierMobile(String supplierMobile) {
		this.supplierMobile = supplierMobile;
	}
	
	
}
