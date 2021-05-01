package com.SpringDemo.springboot.Demo.service.userService;

import com.SpringDemo.springboot.Demo.models.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();

    public User findById(int theId);

    public void save(User theUser);

    public String deleteById(int theId);

}

