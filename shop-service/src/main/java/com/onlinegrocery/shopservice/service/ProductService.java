package com.onlinegrocery.shopservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinegrocery.shopservice.dto.ProductUpdateRequest;
import com.onlinegrocery.shopservice.entity.Product;
import com.onlinegrocery.shopservice.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product addProduct(Product product) {
		System.out.println("Adding Product: " + product);
		product.setIsActive(true);
        return productRepository.save(product);
    }

    public List<Product> getAllActiveProducts() {
    	List<Product> myList = productRepository.findByIsActiveTrue();
        for(Product each : myList) {
        	System.out.println("Product: " + each);
        }
    	return myList;
    }

    public Product getProductById(Long id) {
    	return productRepository.findById(id)
    	        .filter(Product::getIsActive)
    	        .orElse(null);
    }
    
    public String softDeleteProduct(Long id) {
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isPresent()) {
            Product product = optional.get();
            product.setIsActive(false);
            productRepository.save(product);
            return "Product ID " + id + " soft deleted (isActive=false)";
        }
        return "Product not found";
    }
    
    public String updateProduct(Long id, ProductUpdateRequest updatedProduct) {
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isPresent()) {
        	Product product = optional.get();
        	product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            product.setQuantityAvailable(updatedProduct.getQuantityAvailable());
            product.setDescription(updatedProduct.getDescription());
            product.setCategory(updatedProduct.getCategory());
            product.setIsActive(updatedProduct.getIsActive());
            productRepository.save(product);
            return "Product updated successfully.";
        }
        return "Product not found.";
    }
	
}