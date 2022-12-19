package com.product.model.vo;

import java.sql.Date;

public class Product {
	
	// 필드부
	private int pNO;
	private String pName;
	private int price;
	private String national;
	private String brand;
	private String ssgAble;
	private String category;
	private Date regDate;
	
	// 생성자
	
	public Product() {}
	
	public Product(int pNO, String pName, int price, String national, String brand, String ssgAble, String category,
			Date regDate) {
		super();
		this.pNO = pNO;
		this.pName = pName;
		this.price = price;
		this.national = national;
		this.brand = brand;
		this.ssgAble = ssgAble;
		this.category = category;
		this.regDate = regDate;
	}

	public Product(String pName, int price, String national, String brand, String ssgAble, String category) {
		this.pName = pName;
		this.price = price;
		this.national = national;
		this.brand = brand;
		this.ssgAble = ssgAble;
		this.category = category;
	}
	
	// getter setter
	


	public int getpNO() {
		return pNO;
	}

	public void setpNO(int pNO) {
		this.pNO = pNO;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getNational() {
		return national;
	}

	public void setNational(String national) {
		this.national = national;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSsgAble() {
		return ssgAble;
	}

	public void setSsgAble(String ssgAble) {
		this.ssgAble = ssgAble;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	// tostring
	
	@Override
	public String toString() {
		return "Product [pNO=" + pNO + ", pName=" + pName + ", price=" + price + ", national=" + national + ", brand="
				+ brand + ", ssgAble=" + ssgAble + ", category=" + category + ", regDate=" + regDate + "]";
	}
	
	
}
