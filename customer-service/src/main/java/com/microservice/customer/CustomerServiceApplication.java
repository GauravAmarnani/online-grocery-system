package com.microservice.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.microservice.customer.client")
@SpringBootApplication
public class CustomerServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	
}
