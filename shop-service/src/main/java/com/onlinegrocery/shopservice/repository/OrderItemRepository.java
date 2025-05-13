package com.onlinegrocery.shopservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinegrocery.shopservice.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
