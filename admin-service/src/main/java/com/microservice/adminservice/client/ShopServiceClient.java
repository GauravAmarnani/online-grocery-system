package com.microservice.adminservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.adminservice.dto.OrderDisplayDTO;
import com.microservice.adminservice.dto.ProductUpdateRequest;
import com.microservice.adminservice.model.Product;

@FeignClient(name = "shop-service", url = "${services.shop-service.url}")
public interface ShopServiceClient {
	
	@GetMapping("/order")
    List<OrderDisplayDTO> getAllOrders();
	
	@PostMapping("/products/add")
    Product addProduct(@RequestBody Product product);

    @PutMapping("/products/update/{id}")
    String updateProduct(@PathVariable("id") Long id, @RequestBody ProductUpdateRequest request);

    @DeleteMapping("/products/delete/{id}")
    String deleteProduct(@PathVariable("id") Long id);

    @GetMapping("/products")
    List<Product> getAllActiveProducts();

    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable("id") Long id);
	
}
