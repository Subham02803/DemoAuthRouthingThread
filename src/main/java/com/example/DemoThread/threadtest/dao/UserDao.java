package com.example.DemoThread.threadtest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DemoThread.threadtest.model.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
