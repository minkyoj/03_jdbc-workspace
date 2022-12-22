package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.ProductController;
import com.kh.model.vo.Product;

public class ProductMenu {
	Scanner sc = new Scanner(System.in);
	ProductController pc = new ProductController();

	public void mainMenu() {
		
		boolean flag = true;
		
		
		while(flag) {
			System.out.println("1. 전체 조회 하기");
			System.out.println("2. 상품 추가 하기");
			System.out.println("3. 상품 수정 하기 (상품id로 조회하고 수정)");
			System.out.println("4. 상품 삭제 하기 (상품id로 조회해서 삭제)");
			System.out.println("5. 상품 검색 하기 (상품 이름으로 키워드 검색)");
			System.out.println("0. 프로그램 종료하기");
			System.out.print(">> 메뉴선택 :");
			
			int menu = sc.nextInt();
			
			sc.nextLine();
			
			switch (menu) {
			case 1:
				pc.selectList();
				break;
			case 2:
				inputProduct();
				break;
			case 3:
				updateProduct();
				break;
			case 4:
				break;
			case 5:
				break;
			case 0:
				flag = false;
			default:
				break;
			}
			
		}
		
		
		
	}


	private void inputProduct() {
		
		System.out.print("상품아이디 : ");
		String productId = sc.nextLine();
		System.out.print("상품명 : ");
		String pName = sc.nextLine();
		System.out.print("상품가격 : ");
		String price = sc.nextLine();
		System.out.print("상품상세정보 : ");
		String description = sc.nextLine();
		System.out.print("재고 : ");
		String stock = sc.nextLine();
		
		pc.inputProduct(productId, pName, Integer.parseInt(price), description, Integer.parseInt(stock));
		
	}

	private void updateProduct() {
		
		System.out.print("수정할 상품아이디 : ");
		String productId = sc.nextLine();
		System.out.print("상품명 수정 값 : ");
		String pName = sc.nextLine();
		System.out.print("가격 수정 값 : ");
		String price = sc.nextLine();
		System.out.print("상세정보 수정 값 : ");
		String description = sc.nextLine();
		System.out.print("재고 수정 값 : ");
		String stock = sc.nextLine();
		
		pc.updateProduct(productId, pName, price, description, stock);
		
	}
	
	
	/**
	 * 조회 실패 시에 호출되는 메소드
	 * 
	 * @param message 출력하는 문구
	 */
	public void displayFail(String message) {
		System.out.println(message);
	}
	
	public void displaySuccess(String message) {
		System.out.println(message);
	}

	public void selectList(ArrayList<Product> list) {
		for (Product p : list) {
			System.out.println(p);
		}
	}


}
