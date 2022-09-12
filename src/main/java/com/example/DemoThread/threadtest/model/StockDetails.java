package com.example.DemoThread.threadtest.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stock_details")
public class StockDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "stock_industry")
	private String stockIndustry;
	@Column(name = "stock_market")
	private String stockMarket;
	@Column(name = "amount")
	private BigDecimal amount;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id", referencedColumnName = "id")
	private User user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public StockDetails(String stockIndustry, String stockMarket, BigDecimal amount, User user) {
		super();
		this.stockIndustry = stockIndustry;
		this.stockMarket = stockMarket;
		this.amount = amount;
		this.user = user;
	}
	public StockDetails() {
		super();
	}
}
