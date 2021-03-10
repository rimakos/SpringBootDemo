package com.SpringDemo.springboot.Demo.dao;

import com.SpringDemo.springboot.Demo.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("select o from Order o where o.user.id=:id")
    public List<Order> getUserOrders(@Param("id") int id );
}

