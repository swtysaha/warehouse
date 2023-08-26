package com.shawfurniturespace.warehouse.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Warehouses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "capacity")
	private Integer capacity;

	@Column(name = "Available_space")
	private Integer availableSpace;

	@Column(name = "location")
	private String location;

	/**
	 * @return the availableSpace
	 */
	public Integer getAvailableSpace() {
		return availableSpace;
	}

	/**
	 * @param availableSpace the availableSpace to set
	 */
	public void setAvailableSpace(Integer availableSpace) {
		this.availableSpace = availableSpace;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	

	/**
	 * @return the capacity
	 */
	public Integer getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

}
