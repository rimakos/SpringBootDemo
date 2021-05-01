package com.SpringDemo.springboot.Demo.service.orderService;

import com.SpringDemo.springboot.Demo.models.Order;

import java.util.List;

public interface OrderService {


    public List<Order> findAll();

    public List<Order> getUserOrders(int userId);

    public Order findById(int theId);

public String deleteById(int theId);
    public int save(Order theOrder);

}
