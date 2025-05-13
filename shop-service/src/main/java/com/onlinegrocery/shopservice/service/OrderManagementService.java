package com.onlinegrocery.shopservice.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinegrocery.shopservice.dto.OrderDisplayDTO;
import com.onlinegrocery.shopservice.dto.OrderItemDisplayDTO;
import com.onlinegrocery.shopservice.entity.Order;
import com.onlinegrocery.shopservice.entity.OrderItem;
import com.onlinegrocery.shopservice.entity.Product;
import com.onlinegrocery.shopservice.repository.OrderItemRepository;
import com.onlinegrocery.shopservice.repository.OrderRepository;
import com.onlinegrocery.shopservice.repository.ProductRepository;

@Service
public class OrderManagementService {


	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Transactional
	public Order placeOrder(String customerEmail, Map<Long, Integer> cartItems) {
		System.out.println("Customer Email: " + customerEmail);
		System.out.println("Cart Items received: " + cartItems);

		BigDecimal totalAmount = BigDecimal.ZERO;
		boolean hasValidItems = false;

		Order order = new Order();
		order.setCustomerId(customerEmail);
		List<OrderItem> orderItems = new ArrayList<>();

		for (Map.Entry<Long, Integer> entry : cartItems.entrySet()) {
			Long productId = entry.getKey();
			Integer quantity = entry.getValue();

			if (quantity != null && quantity > 0) {
				Optional<Product> productOptional = productRepository.findById(productId);
				if (productOptional.isPresent()) {
					Product product = productOptional.get();
					if (product.getQuantityAvailable() >= quantity) {
						BigDecimal itemPrice = product.getPrice().multiply(BigDecimal.valueOf(quantity));
						totalAmount = totalAmount.add(itemPrice);
						hasValidItems = true;

						OrderItem orderItem = new OrderItem();
						orderItem.setProduct(product);
						orderItem.setQuantity(quantity);
						orderItem.setPricePerItem(product.getPrice());
						orderItems.add(orderItem);

						product.setQuantityAvailable(product.getQuantityAvailable() - quantity);
						productRepository.save(product);
					} else {
						throw new RuntimeException("Insufficient stock for product ID: " + productId);
					}
				} else {
					throw new RuntimeException("Product not found with ID: " + productId);
				}
			}
		}

		if (!hasValidItems) {
			throw new RuntimeException("No valid items in the cart to place order.");
		}

		order.setTotalAmount(totalAmount);

		// Save the order first to get the generated ID
		Order savedOrder = orderRepository.save(order);

		// Now save each order item and explicitly set the order ID
		List<OrderItem> savedOrderItems = new ArrayList<>();
		for (OrderItem item : orderItems) {
			item.setOrder(savedOrder);
			savedOrderItems.add(orderItemRepository.save(item));
		}

		savedOrder.setOrderItems(savedOrderItems); // Optionally update the order with the saved items

		return savedOrder;
	}

	public List<Order> getAllOrdersWithDetails() {
		return orderRepository.findAll();
	}

	public List<OrderDisplayDTO> getAllOrdersWithDetailsForDisplay() {
		List<Order> orders = orderRepository.findAll();
		return orders.stream()
				.map(this::convertToOrderDisplayDTO)
				.collect(Collectors.toList());
	}

	private OrderDisplayDTO convertToOrderDisplayDTO(Order order) {
		List<OrderItemDisplayDTO> orderItemDTOs = order.getOrderItems().stream()
				.map(this::convertToOrderItemDisplayDTO)
				.collect(Collectors.toList());

		return new OrderDisplayDTO(
				order.getId(),
				order.getCustomerId(),
				order.getOrderDate(),
				order.getTotalAmount(),
				orderItemDTOs
				);
	}

	private OrderItemDisplayDTO convertToOrderItemDisplayDTO(OrderItem orderItem) {
		Product product = orderItem.getProduct();
		return new OrderItemDisplayDTO(
				product.getName(),
				orderItem.getQuantity(),
				orderItem.getPricePerItem()
				);
	}

}
