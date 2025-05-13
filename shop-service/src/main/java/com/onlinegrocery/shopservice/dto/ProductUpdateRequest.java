package com.onlinegrocery.shopservice.dto;

import java.math.BigDecimal;

public class ProductUpdateRequest {
    private Long id;
    private String name;
    private String category;
    private String description;
    private Integer quantityAvailable;
    private BigDecimal price;
    private Boolean isActive;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getQuantityAvailable() {
		return quantityAvailable;
	}
	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", name=" + name + ", description=" + description
				+ ", price=" + price + ", quantityAvailable=" + quantityAvailable + ", isActive=" + isActive + "]";
	}
	public ProductUpdateRequest(Long id, String category, String name, String description, BigDecimal price, int quantityAvailable,
			Boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.quantityAvailable = quantityAvailable;
		this.description = description;
		this.price = price;
		this.isActive = isActive;
	}
	public ProductUpdateRequest() {
		super();
	}
}
