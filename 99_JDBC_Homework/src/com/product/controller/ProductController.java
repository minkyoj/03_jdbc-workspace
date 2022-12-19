package com.product.controller;

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
		
		
		
		
	}

}
