package com.microservice.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.customer.model.UserCredential;
import com.microservice.customer.repository.UserCredentialRepository;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private UserCredentialRepository userCredentialRepository;

    public List<UserCredential> getAllCustomers() {
        return userCredentialRepository.findByIsActiveTrue();
    }
    
    public UserCredential getCustomerByEmail(String email) {
        return userCredentialRepository.findByEmail(email);
    }

    public UserCredential updateCustomer(String email, com.microservice.customer.dto.CustomerDTO updatedCustomer) {
        UserCredential existingCustomer = userCredentialRepository.findByEmail(email);
        if (existingCustomer != null) {
            existingCustomer.setUsername(updatedCustomer.getCustomerName());
            existingCustomer.setAddress(updatedCustomer.getAddress());
            existingCustomer.setContactNumber(updatedCustomer.getContactNumber());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            return userCredentialRepository.save(existingCustomer);
        }
        return null; 
    }
}
