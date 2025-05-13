package com.onlinegrocery.shopservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinegrocery.shopservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByIsActiveTrue();
	
}
