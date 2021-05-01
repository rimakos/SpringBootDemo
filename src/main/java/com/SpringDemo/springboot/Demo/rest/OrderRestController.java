package com.SpringDemo.springboot.Demo.rest;

import com.SpringDemo.springboot.Demo.models.Order;
import com.SpringDemo.springboot.Demo.service.orderService.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class OrderRestController {
    private OrderService orderService;

    @Autowired
    public OrderRestController(OrderService theOrderService) {
        orderService = theOrderService;
    }

    @GetMapping("/orders")
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/orders/{userId}")
    public Order getOrder(@PathVariable int userId) {

        Order theOrder = orderService.findById(userId);

        return theOrder;
    }

    @PostMapping("/orders")
    public int addOrder(@RequestBody Order theOrder) {


        return orderService.save(theOrder);
    }

    @DeleteMapping("/orders/delete/{id}")
    public String deleteOrder(@PathVariable("id") int id) {
        String result = orderService.deleteById(id);
        return result;
    }

}
