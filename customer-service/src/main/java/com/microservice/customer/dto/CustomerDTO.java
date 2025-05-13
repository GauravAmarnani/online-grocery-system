package com.microservice.customer.dto;

public class CustomerDTO {

    private String customerName;
    private String email;
    private String address;
    private String contactNumber;

    public CustomerDTO() {
    }

    public CustomerDTO(String customerName, String email, String address, String contactNumber) {
		super();
		this.customerName = customerName;
		this.email = email;
		this.address = address;
		this.contactNumber = contactNumber;
	}

	public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
}
