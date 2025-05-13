package com.microservice.customer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.customer.dto.CustomerDTO;
import com.microservice.customer.entity.LoginRequest;
import com.microservice.customer.entity.RegisterRequest;
import com.microservice.customer.model.UserCredential;
import com.microservice.customer.repository.UserCredentialRepository;
import com.microservice.customer.service.CustomerService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/customers")
@Tag(name = "Customer API")
public class CustomerController {
	
	@Autowired
	private UserCredentialRepository userCredentialRepository;
	
	@Autowired
	private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        UserCredential existingUser = userCredentialRepository.findByUsername(request.getUsername());

        if (existingUser != null) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Username already exists");
            return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT); // Return 409 Conflict
        }

        UserCredential user = new UserCredential(request.getUsername(), request.getPassword(), request.getEmail(), request.getAddress(), request.getContactNumber(), true);

        UserCredential savedUser = userCredentialRepository.save(user);

        Map<String, String> successResponse = new HashMap<>();
        successResponse.put("message", "Customer registered successfully");
        successResponse.put("customerId", String.valueOf(savedUser.getId())); // Optionally return the generated ID

        return new ResponseEntity<>(successResponse, HttpStatus.CREATED); // Return 201 Created
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        UserCredential userCredential = userCredentialRepository.findByEmail(request.getUsername());

        // Check if userCredential is null
        if (userCredential == null || userCredential.getPassword() == null) {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }

        // Check if password matches
        if (!userCredential.getPassword().equals(request.getPassword())) {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }

        Map<String, String> response = new HashMap<>();
        response.put("message", "Login successful as CUSTOMER");
        response.put("role", "CUSTOMER");
        response.put("email", userCredential.getEmail());

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    
    // View All Customers
    
    @GetMapping("/all")
    public ResponseEntity<List<UserCredential>> getAllCustomers() {
        List<UserCredential> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    
    // Update All Customers
    
    @GetMapping("/profile/{email}")
    public ResponseEntity<UserCredential> getCustomerProfile(@PathVariable String email) {
        UserCredential customer = customerService.getCustomerByEmail(email);
        if (customer != null) 
            return ResponseEntity.ok(customer);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/profile/{email}")
    public ResponseEntity<UserCredential> updateCustomerProfile(@PathVariable String email, @RequestBody CustomerDTO updatedCustomer) {
        UserCredential updated = customerService.updateCustomer(email, updatedCustomer);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
