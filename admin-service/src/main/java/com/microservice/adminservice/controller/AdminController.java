package com.microservice.adminservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice.adminservice.client.CustomerServiceClient;
import com.microservice.adminservice.client.ShopServiceClient;
import com.microservice.adminservice.dto.OrderDisplayDTO;
import com.microservice.adminservice.model.AdminCredential;
import com.microservice.adminservice.model.Customer;
import com.microservice.adminservice.model.LoginRequest;
import com.microservice.adminservice.model.RegisterRequest;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@SuppressWarnings("unused")
@Tag(name = "Admin API")
public class AdminController {
	
	private final CustomerServiceClient customerClient;
	private final ShopServiceClient orderServiceClient;

	private RestTemplate restTemplate = new RestTemplate();

	public AdminController(	CustomerServiceClient customerClient,
							ShopServiceClient orderServiceClient) {
		this.customerClient = customerClient;
		this.orderServiceClient = orderServiceClient;
	}

	@Autowired
	private com.microservice.adminservice.repository.UserCredentialRepository repository;

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegisterRequest request) {

		Optional<AdminCredential> existingUser = repository.findByUsername(request.getUsername());

		if (existingUser.isPresent()) {
			return new ResponseEntity<>("ADMIN already exists", HttpStatus.CONFLICT);
		}

		AdminCredential user = new AdminCredential(request.getUsername(), request.getPassword()); // Consider encoding password here

		repository.save(user);

		return new ResponseEntity<>("ADMIN registered successfully", HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request) {

		Optional<AdminCredential> userOpt = repository.findByUsername(request.getUsername());

		if (userOpt.isEmpty()) {
			return new ResponseEntity<>("Invalid Credentials", HttpStatus.UNAUTHORIZED); // Return 401
		}

		AdminCredential user = userOpt.get();
		if (!user.getPassword().equals(request.getPassword())) {
			return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED); // Return 401
		}

		Map<String, String> response = new HashMap<>();
		response.put("message", "Login successful as ADMIN");
		response.put("adminId", user.getId() + "");
		response.put("adminName", user.getUsername());

		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(response);
	}
	
	@GetMapping("/customers/view")
	public List<Customer> viewAllCustomers() {
		return customerClient.getAllCustomers();
	}
	
	@GetMapping("/orders/view")
	public List<OrderDisplayDTO> viewAllOrders() {
		return orderServiceClient.getAllOrders();
	}
	
}
