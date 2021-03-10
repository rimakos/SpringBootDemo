package com.SpringDemo.springboot.Demo.dao;

import com.SpringDemo.springboot.Demo.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
