package com.example.DemoAuthRouthingThread.threadtest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DemoAuthRouthingThread.threadtest.model.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
