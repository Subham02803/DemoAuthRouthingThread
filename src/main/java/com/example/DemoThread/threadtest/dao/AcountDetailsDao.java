package com.example.DemoThread.threadtest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.DemoThread.threadtest.model.AcountDetails;

public interface AcountDetailsDao extends JpaRepository<AcountDetails, Integer> {

	@Query("select ad from AcountDetails ad where ad.user.id in (:ids)")
	List<AcountDetails> findByUsers(@Param("ids") List<Integer> ids);
}
