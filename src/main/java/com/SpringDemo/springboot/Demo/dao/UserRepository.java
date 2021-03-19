package com.SpringDemo.springboot.Demo.dao;

import com.SpringDemo.springboot.Demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {




}
