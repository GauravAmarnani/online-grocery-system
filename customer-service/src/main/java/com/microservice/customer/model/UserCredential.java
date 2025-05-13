package com.microservice.customer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_details")
public class UserCredential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String address;
    private String contactNumber;
    private Boolean isActive;
    
    private final String role = "CUSTOMER"; 
	
    public Long getId() {
		return id;
	}
	
    public void setId(Long id) {
		this.id = id;
	}
	
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

	public UserCredential(Long id, String username, String password, String email, String address, String contactNumber,
			Boolean isActive) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.contactNumber = contactNumber;
		this.isActive = isActive;
	}

	public UserCredential(String username, String password, String email, String address, String contactNumber,
			Boolean isActive) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.contactNumber = contactNumber;
		this.isActive = isActive;
	}

	public UserCredential(String username, String password, String email, String address, String contactNumber) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.contactNumber = contactNumber;
	}

	public UserCredential() {
		super();
	}

	@Override
	public String toString() {
		return "UserCredential [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", address=" + address + ", contactNumber=" + contactNumber + ", isActive=" + isActive + ", role="
				+ role + "]";
	}
}
