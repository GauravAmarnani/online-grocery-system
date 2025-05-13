package com.microservice.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.adminservice.model.AdminCredential;

import java.util.Optional;

public interface UserCredentialRepository extends JpaRepository<AdminCredential, Long> {
    Optional<AdminCredential> findByUsername(String username);
}
