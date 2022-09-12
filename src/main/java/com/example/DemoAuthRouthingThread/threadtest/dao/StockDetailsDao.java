package com.example.DemoAuthRouthingThread.threadtest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.DemoAuthRouthingThread.threadtest.model.StockDetails;

public interface StockDetailsDao extends JpaRepository<StockDetails, Integer> {

	@Query("select s from StockDetails s where s.user.id in (:ids)")
	List<StockDetails> findByUsers(@Param("ids") List<Integer> ids);

}
