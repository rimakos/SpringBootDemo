package com.SpringDemo.springboot.Demo.service.userService;

import com.SpringDemo.springboot.Demo.dao.UserRepository;
import com.SpringDemo.springboot.Demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository theUserRepository) {
        userRepository = theUserRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


    @Override
    public User findById(int theId) {
        return userRepository.findById(theId).orElse(null);
    }


    @Override
    public void save(User theUser) {
        userRepository.save(theUser);
    }

    @Override
    public String deleteById(int theId) {
        Optional<User> user = userRepository.findById(theId);
        if (user.isPresent()) {
            userRepository.deleteById(theId);
            return "The User with id " + theId + " is deleted";
        } else {
            return "The id " + theId + " you enter to delete does not exist";
        }
    }


    }





