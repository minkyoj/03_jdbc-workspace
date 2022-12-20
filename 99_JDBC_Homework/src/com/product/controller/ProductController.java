package com.product.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.product.model.dao.ProductDao;
import com.product.model.vo.Product;
import com.product.view.ProductMenu;

public class ProductController {

	/**
	 * 상품추가 시에 입력받은 값을 옮겨 담아 Dao로 넘겨주는 메소드
	 * @param pName		: 입력받은 상품명
	 * @param price		: 입력받은 가격
	 * @param national	: 입력받은 원산지
	 * @param brand		: 입력받은 브랜드
	 * @param ssgAble	: 입력받은 쓱배송가능여부
	 * @param category	: 입력받은 상품분류
	 */
	public void inputProduct(String pName, String price, String national, String brand, String ssgAble,
			String category) {
		
		Product p = new Product(pName, Integer.parseInt(price), national, brand, ssgAble, category);
		
		int result = new ProductDao().inputProduct(p);
		
		if(result > 0) {
			new ProductMenu().DisplaySuccess("상품추가 성공했습니다.");
		}else {
			new ProductMenu().DisplayFail("상품추가 실패했습니다.");
		}
		
	}

	/**
	 * 회원 전체를 조회해주는 메소드
	 */
	public void selectProduct() {
		
		ArrayList<Product> list = new ProductDao().selectList();
		
		if(list.isEmpty()) {
			new ProductMenu().DisplayFail("상품조회에 실패하였습니다.");
		}else {
			new ProductMenu().DisplayProductList(list);
		}
		
		
		
	}

	public void selectByPname(String keyword) {
		
		ArrayList<Product> list = new ProductDao().selectByPname(keyword);
		
		if(list.isEmpty()) {
			new ProductMenu().DisplayFail(keyword+"의 검색결과가 존재하지않습니다.");
		}else {
			new ProductMenu().DisplayProductList(list);
		}
		
	}

	public void updateProduct(String pName, String price, String ssgAble) {
		
		Product p = new Product();
		
		p.setpName(pName);
		p.setPrice(Integer.parseInt(price));
		p.setSsgAble(ssgAble);
		
		int result = new ProductDao().updateProduct(p);
		
		if(result > 0) {
			new ProductMenu().DisplaySuccess(pName+"의 상품 정보가 변경되었습니다.");
		}else {
			new ProductMenu().DisplayFail(pName+"의 상품 정보 변경에 실패하였습니다.");
		}
		
	}

	public void deleteProduct(String pName) {
		
		int result = new ProductDao().deleteProduct(pName);
		
		if(result > 0) {
			new ProductMenu().DisplaySuccess(pName+"의 상품이 삭제되었습니다.");
		}else {
			new ProductMenu().DisplayFail(pName+"의 상품 삭제 실패하였습니다.");
		}
		
		
	}

	public void selectSsgProduct() {
		
		ArrayList <Product> list = new ProductDao().selectSsgProduct();
		
		if(list.isEmpty()) {
			new ProductMenu().DisplayFail("조회에 실패하였습니다.");
		}else {
			new ProductMenu().DisplayProductList(list);
		}
		
	}

	public void selectPriceProduct(String minPrice, String maxPrice) {

		ArrayList<Product> list = new ProductDao().selectPriceProduct(Integer.parseInt(minPrice), Integer.parseInt(maxPrice));

		if (list.isEmpty()) {
			new ProductMenu().DisplayFail("조회에 실패하였습니다.");
		} else {
			new ProductMenu().DisplayProductList(list);
		}

	}

}
