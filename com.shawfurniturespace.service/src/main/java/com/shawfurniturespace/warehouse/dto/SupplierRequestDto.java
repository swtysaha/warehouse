package com.shawfurniturespace.warehouse.dto;

public class SupplierRequestDto {

	private Integer supplierId;
	private String supplierName;
	private String supplierEmail;
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
