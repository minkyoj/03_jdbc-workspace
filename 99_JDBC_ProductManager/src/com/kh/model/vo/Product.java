package com.kh.model.vo;

public class Product {
	
	//필드부
	private String productId;
	private String pName;
	private int price;
	private String description;
	private int stock;
	
	//생성자
	public Product() {}

	public Product(String productId, String pName, int price, String description, int stock) {
		super();
		this.productId = productId;
		this.pName = pName;
		this.price = price;
		this.description = description;
		this.stock = stock;
	}

	
	//gettersetter
	
	public String getProductId() {
		return productId;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}

	//tostring
	@Override
	public String toString() {
		return "[상품 아이디 : " + productId + ", 상품명 : " + pName + ", 가격 : " + price + ", 상품상세정보 : "
				+ description + ", 재고 : " + stock + "]";
	}
	
	
}
