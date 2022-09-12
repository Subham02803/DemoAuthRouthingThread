package com.example.DemoThread.threadtest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.DemoThread.threadtest.model.StockDetails;

public interface StockDetailsDao extends JpaRepository<StockDetails, Integer> {

	@Query("select s from StockDetails s where s.user.id in (:ids)")
	List<StockDetails> findByUsers(@Param("ids") List<Integer> ids);

}
