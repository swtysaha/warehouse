package com.shawfurniturespace.warehouse.dto;



public class AddressRequestDto {
	private Integer addressId;
	private String customerStreet	;
	private String customerTown;
	private String customerPostcode;
	private Integer customerId;
	/**
	 * @return the addressId
	 */
	public Integer getAddressId() {
		return addressId;
	}
	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	/**
	 * @return the customerStreet
	 */
	public String getCustomerStreet() {
		return customerStreet;
	}
	/**
	 * @param customerStreet the customerStreet to set
	 */
	public void setCustomerStreet(String customerStreet) {
		this.customerStreet = customerStreet;
	}
	/**
	 * @return the customerTown
	 */
	public String getCustomerTown() {
		return customerTown;
	}
	/**
	 * @param customerTown the customerTown to set
	 */
	public void setCustomerTown(String customerTown) {
		this.customerTown = customerTown;
	}
	/**
	 * @return the customerPostcode
	 */
	public String getCustomerPostcode() {
		return customerPostcode;
	}
	/**
	 * @param customerPostcode the customerPostcode to set
	 */
	public void setCustomerPostcode(String customerPostcode) {
		this.customerPostcode = customerPostcode;
	}
	/**
	 * @return the customerId
	 */
	public Integer getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
}
