package com.SpringDemo.springboot.Demo.rest;

import com.SpringDemo.springboot.Demo.models.Order;
import com.SpringDemo.springboot.Demo.models.User;
import com.SpringDemo.springboot.Demo.service.orderService.OrderService;
import com.SpringDemo.springboot.Demo.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class UserRestController {
    private OrderService orderService;
    private UserService userService;

    @Autowired
    public UserRestController(UserService theUserService, OrderService orderService) {
        this.orderService = orderService;
        this.userService = theUserService;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId) {

        User theUser = userService.findById(userId);

        if (theUser == null) {
            throw new RuntimeException("User id not found - " + userId);
        }

        return theUser;


    }

    @GetMapping("/users/orders/{userId}")
    public List<Order> getUserOrders(@PathVariable int userId) {
        return orderService.getUserOrders(userId);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody @Valid User theUser) {
        userService.save(theUser);

        return theUser;
    }
    @DeleteMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        String result = userService.deleteById(id);
        return result;
    }
}







