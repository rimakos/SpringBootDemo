package com.SpringDemo.springboot.Demo.rest;

import com.SpringDemo.springboot.Demo.models.OrderItem;
import com.SpringDemo.springboot.Demo.service.orderItemService.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class OrderItemRestController {


    private OrderItemService orderItemService;

    @Autowired
    public OrderItemRestController(OrderItemService theOrderItemService) {
        orderItemService = theOrderItemService;
    }


    @GetMapping("/order-items")
    public List<OrderItem> findAll() {
        return orderItemService.findAll();
    }


    @GetMapping("/order-items/{userId}")
    public OrderItem getOrderItem(@PathVariable int userId) {

        OrderItem theOrderItem = orderItemService.findById(userId);

        return theOrderItem;
    }

    @PostMapping("/order-items")
    public OrderItem addOrderItem(@RequestBody @Valid OrderItem theOrderItem) {

        orderItemService.save(theOrderItem);

        return theOrderItem;
    }

    @DeleteMapping("/order-items/delete/{id}")
    public String deleteOrder(@PathVariable("id") int id) {
        String result = orderItemService.deleteById(id);
        return result;
    }
}
