package com.example.DemoAuthRouthingThread.threadtest.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.DemoAuthRouthingThread.threadtest.dao.AcountDetailsDao;
import com.example.DemoAuthRouthingThread.threadtest.model.AcountDetails;

@Service
public class AcountDetailsService {
	
	@Autowired
	private AcountDetailsDao acountDetailsDao;
	
	Logger log = LoggerFactory.getLogger(AcountDetailsService.class);
	
	public List<AcountDetails> getAllAccounts(){
		log.info("in getAllUsers Service by " + Thread.currentThread().getName());
		return acountDetailsDao.findAll();
	}
	
	public List<AcountDetails> saveAllAccounts(List<AcountDetails> stockDetails){
		log.info("in saveUsers Service by " + Thread.currentThread().getName());
		return acountDetailsDao.saveAll(stockDetails);
	}
	
	public List<AcountDetails> getAllAccountsByUserIds(List<Integer> userIds){
		log.info("in getAllAccountsByUserIds Service by " + Thread.currentThread().getName());
		return acountDetailsDao.findAllById(userIds);
	}
}
