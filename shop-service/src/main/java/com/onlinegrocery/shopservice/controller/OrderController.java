package com.onlinegrocery.shopservice.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinegrocery.shopservice.dto.OrderDisplayDTO;
import com.onlinegrocery.shopservice.entity.Order;
import com.onlinegrocery.shopservice.service.OrderManagementService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/order")
@Tag(name = "ORDER API")
public class OrderController {
	
	@Autowired
	private OrderManagementService orderManagementService;

	@PostMapping("/place-order/{customerId}")
	public ResponseEntity<?> placeOrder(@PathVariable String customerId, @RequestBody Map<Long, Integer> cartItems) {
		try {
			Order order = orderManagementService.placeOrder(customerId, cartItems);
			Map<String, Object> response = new HashMap<>();
			response.put("message", "Order placed successfully");
			response.put("orderId", order.getId());
			response.put("customerEmail", customerId); // Optionally return the customerEmail

			return ResponseEntity.status(HttpStatus.CREATED)
					.contentType(MediaType.APPLICATION_JSON)
					.body(response);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping
	public ResponseEntity<List<OrderDisplayDTO>> getAllOrderDetailsForDisplay() {
		List<OrderDisplayDTO> orderDTOs = orderManagementService.getAllOrdersWithDetailsForDisplay();
		return ResponseEntity.ok(orderDTOs);
	}

}
