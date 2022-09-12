package com.example.DemoAuthRouthingThread.auth.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DemoAuthRouthingThread.auth.model.DBUser;

public interface UserRepository extends JpaRepository<DBUser, Integer> {
	public DBUser findByUserName(String userName);
}
