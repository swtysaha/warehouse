package com.shawfurniturespace.warehouse.dto;

public class WarehousesRequestDto {

	private Integer id;
	private String location;

	private Integer capacity;
	
	private Integer availableSpace;


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
	
	
	

}
