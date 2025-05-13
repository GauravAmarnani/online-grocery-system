package com.microservice.adminservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.adminservice.client.ShopServiceClient;
import com.microservice.adminservice.dto.ProductUpdateRequest;
import com.microservice.adminservice.model.Product;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/admin/products")
@Tag(name = "Admin Product Management API")
public class AdminProductController {
	
	@Autowired
    private ShopServiceClient productManagementServiceClient;

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product addedProduct = productManagementServiceClient.addProduct(product);
        //addedProduct.setId(null);
        return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody ProductUpdateRequest request) {
        String updateResult = productManagementServiceClient.updateProduct(id, request);
        return ResponseEntity.ok(updateResult);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        String deleteResult = productManagementServiceClient.deleteProduct(id);
        return ResponseEntity.ok(deleteResult);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllActiveProducts() {
        List<Product> activeProducts = productManagementServiceClient.getAllActiveProducts();
        return ResponseEntity.ok(activeProducts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productManagementServiceClient.getProductById(id);
        if (product != null) 
            return ResponseEntity.ok(product);
        return ResponseEntity.notFound().build();
    }
}