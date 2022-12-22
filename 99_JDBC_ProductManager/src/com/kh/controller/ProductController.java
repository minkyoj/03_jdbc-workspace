package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.service.ProductService;
import com.kh.model.vo.Product;
import com.kh.view.ProductMenu;

public class ProductController {

	public void selectList() {
		
		ArrayList<Product> list = new ProductService().selectList();
		
		if(list.isEmpty()) {
			new ProductMenu().displayFail("전체 조회 실패");
		}else {
			new ProductMenu().selectList(list);
		}
		
	}
	
	public void inputProduct(String productId, String pName, int price, String description, int stock) {
		
		Product p = new Product();
		
		p.setProductId(productId);
		p.setpName(pName);
		p.setPrice(price);
		p.setDescription(description);
		p.setStock(stock);
		
		int result = new ProductService().inputProduct(p);
		
		if(result > 0) {
			new ProductMenu().displaySuccess("상품 추가 성공");
		}else {
			new ProductMenu().displayFail("상품 추가 실패");
		}
		
	}

	public void updateProduct(String productId, String pName, String price, String description, String stock) {
		
		Product p = new Product();
		
		
		
		
		
	}

}
