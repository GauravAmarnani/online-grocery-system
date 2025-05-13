package com.onlinegrocery.shopservice.controller;

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

import com.onlinegrocery.shopservice.dto.ProductUpdateRequest;
import com.onlinegrocery.shopservice.entity.Product;
import com.onlinegrocery.shopservice.service.ProductService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/products")
@Tag(name = "PRODUCT API")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
		System.out.println("Adding Product: " + product);
        return productService.addProduct(product);
    }
    
    @PutMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @RequestBody ProductUpdateRequest request) {
        return productService.updateProduct(id, request);
    }
    
    @DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		return productService.softDeleteProduct(id);
	}

    @GetMapping
    public List<Product> getAllActiveProducts() {
        return productService.getAllActiveProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
    	Product product = productService.getProductById(id);
        if(product != null)
        	return ResponseEntity.ok(product);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("Product with ID " + id + " not found.");
    }
	
}
