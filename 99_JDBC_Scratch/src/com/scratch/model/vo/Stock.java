package com.scratch.model.vo;

import java.sql.Date;

public class Stock {
	
	// 필드부
	
	private String stockNo;
	private String stockName;
	private String market;
	private String sector;
	private String address;
	private String estDate;
	private String crapeDate;
	private int stockCount;
	
	// 생성자부, 기본생성자 / 매개변수생성자
	
	public Stock() {}
	
	
	/*
	public Stock(String stockNo, String stockName, String market, String sector, String address, Date estDate,
			Date crapeDate, int stockCount) {
		super();
		this.stockNo = stockNo;
		this.stockName = stockName;
		this.market = market;
		this.sector = sector;
		this.address = address;
		this.estDate = estDate;
		this.crapeDate = crapeDate;
		this.stockCount = stockCount;
	}

	public Stock(String stockNo, String stockName, String market, String sector, String address,
			java.util.Date eDate, java.util.Date cDate, int stockCount) {
		super();
		this.stockNo = stockNo;
		this.stockName = stockName;
		this.market = market;
		this.sector = sector;
		this.address = address;
		this.estDate = (Date) eDate;
		this.crapeDate = (Date) cDate;
		this.stockCount = stockCount;
	}
	*/
	
	public Stock(String stockNo, String stockName, String market, String sector, String address, String estDate,
			String crapeDate, int stockCount) {
		super();
		this.stockNo = stockNo;
		this.stockName = stockName;
		this.market = market;
		this.sector = sector;
		this.address = address;
		this.estDate = estDate;
		this.crapeDate = crapeDate;
		this.stockCount = stockCount;
	}
	
	// getter, setter
	


	


	public String getStockNo() {
		return stockNo;
	}
	
	public void setStockNo(String stockNo) {
		this.stockNo = stockNo;
	}
	
	public String getStockName() {
		return stockName;
	}
	
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	
	public String getMarket() {
		return market;
	}
	
	public void setMarket(String market) {
		this.market = market;
	}
	
	public String getSector() {
		return sector;
	}
	
	public void setSector(String sector) {
		this.sector = sector;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getEstDate() {
		return estDate;
	}


	public void setEstDate(String estDate) {
		this.estDate = estDate;
	}


	public String getCrapeDate() {
		return crapeDate;
	}


	public void setCrapeDate(String crapeDate) {
		this.crapeDate = crapeDate;
	}


	public int getStockCount() {
		return stockCount;
	}
	
	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}
	
	//toString()
	
	@Override
	public String toString() {
		return "Stock [stockNo=" + stockNo + ", stockName=" + stockName + ", market=" + market + ", sector=" + sector
				+ ", address=" + address + ", estDate=" + estDate + ", crapeDate=" + crapeDate + ", stockCount="
				+ stockCount + "]";
	}
	
	
	
	
}
