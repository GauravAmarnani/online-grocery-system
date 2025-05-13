package com.microservice.customer.entity;

public class RegisterRequest {
    
	private String username;
    private String password;
    private String email;
    private String address;
    private String contactNumber;
    private Boolean isActive;
    private String role;
    
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public RegisterRequest(String username, String password, String email, String address, String contactNumber,
			Boolean isActive, String role) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.contactNumber = contactNumber;
		this.isActive = isActive;
		this.role = role;
	}
	
	public RegisterRequest() {
		super();
	}
	
	@Override
	public String toString() {
		return "RegisterRequest [username=" + username + ", password=" + password + ", email=" + email + ", address="
				+ address + ", contactNumber=" + contactNumber + ", isActive=" + isActive + ", role=" + role + "]";
	}
}

