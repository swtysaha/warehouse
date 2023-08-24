package com.shawfurniturespace.warehouse.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_item_id")
	private Integer orderItemId;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private Order order;
	

	@OneToOne
    @JoinColumn(name="product_id")
	private Product product;
	

	@Column(name="quantity")
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
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}


	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}


	
	
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}


	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
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
