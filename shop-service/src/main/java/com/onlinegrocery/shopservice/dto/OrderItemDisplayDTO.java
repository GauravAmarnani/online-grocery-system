package com.onlinegrocery.shopservice.dto;

import java.math.BigDecimal;

public class OrderItemDisplayDTO {
	private String productName;
	private int quantity;
	private BigDecimal pricePerItem;
	private BigDecimal itemTotalPrice;

	public OrderItemDisplayDTO() {
	}

	public OrderItemDisplayDTO(String productName, int quantity, BigDecimal pricePerItem) {
		this.productName = productName;
		this.quantity = quantity;
		this.pricePerItem = pricePerItem;
		this.itemTotalPrice = pricePerItem.multiply(BigDecimal.valueOf(quantity));
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

	public BigDecimal getItemTotalPrice() {
		return itemTotalPrice;
	}

	public void setItemTotalPrice(BigDecimal itemTotalPrice) {
		this.itemTotalPrice = itemTotalPrice;
	}

	@Override
	public String toString() {
		return "OrderItemDisplayDTO [productName=" + productName + ", quantity=" + quantity + ", pricePerItem="
				+ pricePerItem + ", itemTotalPrice=" + itemTotalPrice + "]";
	}
	
	

}
