package com.microservice.adminservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.adminservice.client.ShopServiceClient;
import com.microservice.adminservice.dto.ProductUpdateRequest;
import com.microservice.adminservice.model.Product;

@Service
public class AdminProductService {
	
	@Autowired
    private ShopServiceClient productServiceClient;

    public Product addNewProduct(Product product) {
        return productServiceClient.addProduct(product);
    }

    public String updateExistingProduct(Long id, ProductUpdateRequest request) {
        return productServiceClient.updateProduct(id, request);
    }

    public String removeProduct(Long id) {
        return productServiceClient.deleteProduct(id);
    }

    public List<Product> fetchAllActiveProducts() {
        return productServiceClient.getAllActiveProducts();
    }

    public Product fetchProductDetails(Long id) {
        return productServiceClient.getProductById(id);
    }
	
}
