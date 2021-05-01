package com.SpringDemo.springboot.Demo.service.orderItemService;


import com.SpringDemo.springboot.Demo.models.OrderItem;

import java.util.List;

public interface OrderItemService {
    public List<OrderItem> findAll();

    public OrderItem findById(int theId);

    public void save(OrderItem theOrderItem);

    public String deleteById(int theId);

}
