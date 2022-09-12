package com.example.DemoAuthRouthingThread.threadtest.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.DemoAuthRouthingThread.threadtest.dao.StockDetailsDao;
import com.example.DemoAuthRouthingThread.threadtest.model.StockDetails;

@Service
public class StockDetailsService {
	
	@Autowired
	private StockDetailsDao stockDetailsDao;
	
	Logger log = LoggerFactory.getLogger(StockDetailsService.class);
	
	public List<StockDetails> getAllStocks(){
		log.info("in getAllUsers Service by " + Thread.currentThread().getName());
		return stockDetailsDao.findAll();
	}
	
	public List<StockDetails> saveAllStocks(List<StockDetails> stockDetails){
		log.info("in saveUsers Service by " + Thread.currentThread().getName());
		return stockDetailsDao.saveAll(stockDetails);
	}
	
	public List<StockDetails> getAllStocksByUserIds(List<Integer> ids){
		log.info("in getAllStocksByUserIds Service by " + Thread.currentThread().getName());
		return stockDetailsDao.findAllById(ids);
	}
}
