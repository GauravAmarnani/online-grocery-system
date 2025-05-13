package com.microservice.customer.entity;

import java.util.Date;

public class Order {

    private Long id;
    private Long customerId;
    private Date orderDate;
    private String productName;
    private Integer quantity;
    private Double totalPrice;
    private Boolean isDelivered;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Boolean getIsDelivered() {
        return isDelivered;
    }

    public void setIsDelivered(Boolean isDelivered) {
        this.isDelivered = isDelivered;
    }

	public Order(Long id, Long customerId, Date orderDate, String productName, Integer quantity, Double totalPrice,
			Boolean isDelivered) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.productName = productName;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.isDelivered = isDelivered;
	}

	public Order() {
		super();
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerId=" + customerId + ", orderDate=" + orderDate + ", productName="
				+ productName + ", quantity=" + quantity + ", totalPrice=" + totalPrice + ", isDelivered=" + isDelivered
				+ "]";
	}
    
    
}
