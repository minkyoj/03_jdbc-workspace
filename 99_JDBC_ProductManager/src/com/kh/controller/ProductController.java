package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.service.ProductService;
import com.kh.model.vo.Product;
import com.kh.view.ProductMenu;

public class ProductController {

	public void selectList() {
		
		ArrayList<Product> list = new ProductService().selectList();
		
		if(list.isEmpty()) {
			new ProductMenu().displayFail("전체 조회 실패\n");
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
			new ProductMenu().displaySuccess(productId + " 상품 추가 성공\n");
		}else {
			new ProductMenu().displayFail(productId + " 상품 추가 실패\n");
		}
		
	}

	public void updateProduct(String productId, String pName, int price, String description, int stock) {
		
		Product p = new Product();
		
		p.setProductId(productId);
		p.setpName(pName);
		p.setPrice(price);
		p.setDescription(description);
		p.setStock(stock);
		
		int result = new ProductService().updateProduct(p);
		
		if(result > 0) {
			new ProductMenu().displaySuccess(productId + " 상품 수정 성공\n");
		}else {
			new ProductMenu().displayFail(productId + " 상품 수정 실패\n");
		}
		
	}

	public void deleteProduct(String productId) {

		int result = new ProductService().deleteProduct(productId);

		if (result > 0) {
			new ProductMenu().displaySuccess(productId + " 상품 삭제 성공\n");
		} else {
			new ProductMenu().displayFail(productId + " 상품 삭제 실패\n");
		}

	}

	public void selectByPname(String pName) {
		
		ArrayList<Product> list = new ProductService().selectByPname(pName);
		
		if(list.isEmpty()) {
			new ProductMenu().displayFail(pName + "조회 실패\n");
		}else {
			new ProductMenu().selectList(list);
		}
		
	}

}
