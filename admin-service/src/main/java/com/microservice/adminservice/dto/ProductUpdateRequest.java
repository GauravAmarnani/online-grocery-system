package com.microservice.adminservice.dto;

public class ProductUpdateRequest {
    private Long id;
    private String name;
    private String category;
    private int quantity;
    private double price;
    private boolean isActive;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public ProductUpdateRequest(Long id, String name, String category, int quantity, double price, boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.quantity = quantity;
		this.price = price;
		this.isActive = isActive;
	}
	public ProductUpdateRequest() {
		super();
	}
	@Override
	public String toString() {
		return "ProductUpdateRequest [id=" + id + ", name=" + name + ", category=" + category + ", quantity=" + quantity
				+ ", price=" + price + ", isActive=" + isActive + "]";
	}
	
    
    
    
}
