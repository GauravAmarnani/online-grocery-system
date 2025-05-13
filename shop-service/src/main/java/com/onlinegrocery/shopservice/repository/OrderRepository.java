
package com.onlinegrocery.shopservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinegrocery.shopservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
