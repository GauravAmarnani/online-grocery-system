package com.onlinegrocery.shopservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDisplayDTO {
	private Long id;
	private String customerEmail;
	private LocalDateTime orderDate;
	private BigDecimal totalAmount;
	private List<OrderItemDisplayDTO> orderItems;


	// Constructors (default and parameterized), Getters, and Setters

	public OrderDisplayDTO() {
	}

	public OrderDisplayDTO(Long id, String customerEmail, LocalDateTime orderDate, BigDecimal totalAmount, List<OrderItemDisplayDTO> orderItems) {
		this.id = id;
		this.customerEmail = customerEmail;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.orderItems = orderItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<OrderItemDisplayDTO> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemDisplayDTO> orderItems) {
		this.orderItems = orderItems;
	}


}
