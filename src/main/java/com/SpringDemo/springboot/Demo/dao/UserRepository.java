package com.SpringDemo.springboot.Demo.dao;

import com.SpringDemo.springboot.Demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
