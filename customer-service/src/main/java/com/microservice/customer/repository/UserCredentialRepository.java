package com.microservice.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.customer.model.UserCredential;

import java.util.List;

public interface UserCredentialRepository extends JpaRepository<UserCredential, Long> {
    
	List<UserCredential> findByIsActiveTrue();
	
	UserCredential findByEmail(String email);
    
    UserCredential findByUsername(String username);
}
