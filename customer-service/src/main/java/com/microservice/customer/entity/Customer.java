  package com.microservice.customer.entity;

public class Customer {

    private Long id;
    private String username;
    private String email;
    private String address;
    private String contactNumber;
    private Boolean isActive;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String name) {
		this.username = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Customer(Long id, String name, String email, String address, String contactNumber, Boolean isActive) {
		super();
		this.id = id;
		this.username = name;
		this.email = email;
		this.address = address;
		this.contactNumber = contactNumber;
		this.isActive = isActive;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + username + ", email=" + email + ", address=" + address
				+ ", contactNumber=" + contactNumber + ", isActive=" + isActive + "]";
	}
    
    
	
    
    
}