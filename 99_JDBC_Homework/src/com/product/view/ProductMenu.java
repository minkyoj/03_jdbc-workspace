package com.product.view;

import java.util.Scanner;

import com.product.controller.ProductController;

public class ProductMenu {

	public Scanner sc = new Scanner(System.in);

	public ProductController pc = new ProductController();

	public void mainMenu() {

		boolean flag = true;

		while (flag) { // -- while start

			System.out.println("\n== 쓱(SSG) 상품관리 프로그램 ==");
			System.out.println("1) 상품 추가");
			System.out.println("2) 상품 전체 조회");
			System.out.println("3) 상품명(키워드)으로 검색 ");
			System.out.println("4) 상품 정보 변경");
			System.out.println("5) 상품 정보 삭제");
			System.out.println("6) 쓱배송 가능상품 검색");
			System.out.println("7) 가격대별 검색");
			System.out.println("0) 프로그램 종료");

			System.out.print(">>메뉴 선택 : ");
			int menu = sc.nextInt();

			sc.nextLine();

			switch (menu) {

			case 1:inputProduct();
				break;
			case 2:pc.selectProduct();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				flag = false;
			} // -- while end
			
			

		}

	}

	/**
	 * 추가할 상품 정보를 입력받는 메소드
	 */
	private void inputProduct() {
		System.out.println("\n == 상품추가 메뉴입니다 == ");
		
		System.out.print("상품명 : ");
		String pName = sc.nextLine();
		
		System.out.print("가격 : ");
		String price = sc.nextLine();
		
		System.out.print("원산지 : ");
		String national = sc.nextLine();
		
		System.out.print("브랜드명 : ");
		String brand = sc.nextLine();
		
		System.out.print("쓱배송 가능 여부(Y/N) : ");
		String ssgAble = sc.nextLine();
		
		System.out.print("상품분류 : ");
		String category = sc.nextLine();
		
		pc.inputProduct(pName, price, national, brand, ssgAble, category);
	}
	
	
	
	
	
	//------------------------ 출력화면 --------------------------
	

	/**
	 * 상품추가에 성공했을때 출력하는 화면
	 * @param message 	: 상품추가 성공 문구
	 */
	public void DisplaySuccess(String message) {
		System.out.println(message);
	}

	/**
	 * 상품추가에 실패했을때 출력하는 화면
	 * @param message	: 상품추가 실패 문구
	 */
	public void DisplayFail(String message) {
		System.out.println(message);
	}
}
