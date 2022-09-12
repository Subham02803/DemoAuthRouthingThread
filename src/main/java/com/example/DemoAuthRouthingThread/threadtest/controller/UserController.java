package com.example.DemoAuthRouthingThread.threadtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.DemoAuthRouthingThread.threadtest.dto.CSVParseDto;
import com.example.DemoAuthRouthingThread.threadtest.service.StockService;

@RestController
public class UserController {
	
	@Autowired
	private StockService userService;
	
	@GetMapping(value = "getAllUsersStock",produces = "application/json")
	public List<CSVParseDto> getAllUsers() {
		return userService.getAlStockUserDetails();
	}
//	
//	@PostMapping(value="/saveStockData", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = "application/json")
//	public ResponseEntity saveStockData(@RequestParam(value = "files") MultipartFile[] files) throws Exception {
//		for(MultipartFile file : files) {
//			userService.saveStockData(file);
//		}
//		return ResponseEntity.status(HttpStatus.CREATED).build();
//	}
}
