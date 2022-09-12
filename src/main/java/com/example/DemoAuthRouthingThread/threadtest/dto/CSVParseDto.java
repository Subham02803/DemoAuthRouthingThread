package com.example.DemoAuthRouthingThread.threadtest.dto;

import java.math.BigDecimal;

public class CSVParseDto {
	private int userId;
	private String name;
	private String email;
	private String creditCard;
	private String creditCardType;
	private String stockIndustry;
	private String stockMarket;
	private BigDecimal amount;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	public String getCreditCardType() {
		return creditCardType;
	}
	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}
	public String getStockIndustry() {
		return stockIndustry;
	}
	public void setStockIndustry(String stockIndustry) {
		this.stockIndustry = stockIndustry;
	}
	public String getStockMarket() {
		return stockMarket;
	}
	public void setStockMarket(String stockMarket) {
		this.stockMarket = stockMarket;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public CSVParseDto(String name, String email, String creditCard, String creditCardType, String stockIndustry,
			String stockMarket, BigDecimal amount) {
		super();
		this.name = name;
		this.email = email;
		this.creditCard = creditCard;
		this.creditCardType = creditCardType;
		this.stockIndustry = stockIndustry;
		this.stockMarket = stockMarket;
		this.amount = amount;
	}
	
	public CSVParseDto(int userId, String name, String email, String creditCard, String creditCardType, String stockIndustry,
			String stockMarket, BigDecimal amount) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.creditCard = creditCard;
		this.creditCardType = creditCardType;
		this.stockIndustry = stockIndustry;
		this.stockMarket = stockMarket;
		this.amount = amount;
	}
	
	public CSVParseDto() {
		super();
	}
}
