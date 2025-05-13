package com.microservice.adminservice.dto;

import java.math.BigDecimal;

public class OrderItemDisplayDTO {
    private String productName;
    private int quantity;
    private BigDecimal pricePerItem;

    // Constructors (default and parameterized), Getters, and Setters

    public OrderItemDisplayDTO() {
    }

    public OrderItemDisplayDTO(String productName, int quantity, BigDecimal pricePerItem) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(BigDecimal pricePerItem) {
        this.pricePerItem = pricePerItem;
    }
}
