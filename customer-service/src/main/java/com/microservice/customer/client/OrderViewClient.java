package com.microservice.customer.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.customer.entity.Order;

@FeignClient(name = "order-view-service")
public interface OrderViewClient {
    @GetMapping("/orders/{id}")
    List<Order> getOrdersByCustomerId(@PathVariable("id") Long id);
}