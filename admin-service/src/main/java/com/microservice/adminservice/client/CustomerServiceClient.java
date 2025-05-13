package com.microservice.adminservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.microservice.adminservice.model.Customer;


@FeignClient(name = "customer-service", url = "${services.customer-service.url}")
public interface CustomerServiceClient {
    @GetMapping("/api/customers/all")
    List<Customer> getAllCustomers();
}
