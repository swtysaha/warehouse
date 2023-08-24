package com.shawfurniturespace.warehouse.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Address {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="address_id")
	private Integer addressId;
	
	@Column(name = "customer_street")
	private String customerStreet	;
	
	@Column(name = "customer_town")
	private String customerTown;
	
	@Column(name = "customer_postcode")
	private String customerPostcode;
	
//	@OneToOne
//	@JoinColumn(name="customer_id")
//	private Customer customer;
	
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

//	/**
//	 * @return the customer
//	 */
//	public Customer getCustomer() {
//		return customer;
//	}
//
//	/**
//	 * @param customer the customer to set
//	 */
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}

	


}
