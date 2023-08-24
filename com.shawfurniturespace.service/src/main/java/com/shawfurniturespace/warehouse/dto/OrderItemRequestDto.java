package com.shawfurniturespace.warehouse.dto;



public class OrderItemRequestDto {


	
//no need of this field
private Integer orderItemId;
private Integer orderId;
private Integer productId;
private Integer quantity;
	

/**
 * @return the orderItemId
 */
public Integer getOrderItemId() {
	return orderItemId;
}
/**
 * @param orderItemId the orderItemId to set
 */
public void setOrderItemId(Integer orderItemId) {
	this.orderItemId = orderItemId;
}
/**
 * @return the orderId
 */
public Integer getOrderId() {
	return orderId;
}
/**
 * @param orderId the orderId to set
 */
public void setOrderId(Integer orderId) {
	this.orderId = orderId;
}
/**
 * @return the productId
 */
public Integer getProductId() {
	return productId;
}
/**
 * @param productId the productId to set
 */
public void setProductId(Integer productId) {
	this.productId = productId;
}
/**
 * @return the quantity
 */
public Integer getQuantity() {
	return quantity;
}
/**
 * @param quantity the quantity to set
 */
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}

	
	
}
