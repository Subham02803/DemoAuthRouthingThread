package com.example.DemoAuthRouthingThread.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.DemoAuthRouthingThread.threadtest.dto.CSVParseDto;
import com.example.DemoAuthRouthingThread.threadtest.service.StockService;

@Controller
public class AuthController {
	
	@Autowired
	private StockService userService;
	
	@RequestMapping("/")
	public ModelAndView home(ModelAndView modelView) {
		List<CSVParseDto> list = userService.getAlStockUserDetails();
		modelView.setViewName("home.jsp");
		modelView.addObject("data", list);
		return modelView;
	}
	
	@RequestMapping(value="/saveStockData", method = RequestMethod.POST)
	public ModelAndView saveStockData(@RequestParam(value = "file") MultipartFile file, ModelAndView modelView) throws Exception {
		userService.saveStockData(file);
		List<CSVParseDto> list = userService.getAlStockUserDetails();
		modelView.setViewName("home.jsp");
		modelView.addObject("data", list);
		return modelView;
	}
	
	@RequestMapping("/login")
	public String loginPage() {
		return "login.jsp";
	}
}
