package com.scratch.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.scratch.controller.StockController;
import com.scratch.model.vo.Stock;

public class StockMenu {

	// Scanner 객체 생성 (전역으로 다 쓸 수 있도록)
	private Scanner sc = new Scanner(System.in);

	// MemberController 객체 생성 (전역에서 바로 요청할 수 있게끔)
	private StockController stc = new StockController();

	public void mainMenu() { // -- mainMenu start
		
		boolean flag = true;

		while (flag) { // -- while start

			System.out.println("\n   == 주식종목검색 프로그램 ==");
			System.out.println("┌───────────────────────────────┐");
			System.out.println("│ 1) 종목 추가   \t\t\t│");
			System.out.println("│ 2) 종목전체조회   \t\t│");
			System.out.println("│ 3) 시장별 검색(코스피/코스닥) \t│");
			System.out.println("│ 4) 종목명으로 검색   \t\t│");
			System.out.println("│ 5) 주소로 검색   \t\t│");
			System.out.println("│ 6) 종목 정보 변경   \t\t│");
			System.out.println("│ 7) 종목 삭제   \t\t\t│");
			System.out.println("│ 0) 프로그램 종료   \t\t│");
			System.out.println("└───────────────────────────────┘");
			System.out.print(">> 메뉴 선택 : ");
			int menu = sc.nextInt();

			sc.nextLine();

			switch (menu) {
			case 1:
				insertStock();
				break;
			case 2:
				stc.selectList();
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
				System.out.println("이용해주셔서 감사합니다.");
				flag = false;
			default:
				System.out.println("메뉴를 잘못입력하셨습니다. 다시입력해주세요.");

			} // -- while end

		} // -- mainMenu end

	}

	private void insertStock() {
		System.out.print("종목번호 : ");
		String stockNo = sc.nextLine();

		System.out.print("종목명 : ");
		String stockName = sc.nextLine();

		System.out.print("시장(KOSPI/KOSDAQ) : ");
		String market = sc.nextLine();

		System.out.print("업종 : ");
		String sector = sc.nextLine();
		
		System.out.print("주소 : ");
		String address = sc.nextLine();

		System.out.print("창립일 : ");
		String estDate = sc.nextLine();

		System.out.print("상장일 : ");
		String crapeDate = sc.nextLine();

		System.out.print("발행주식수: ");
		String stockCount = sc.nextLine();
		
		stc.insertStock(stockNo, stockName, market, sector, address, estDate, crapeDate, stockCount);
	}
	
	/*
	private void vaild(Stock s) {
		
		if(Integer.parseInt(s.getStockNo()) < 1 || Integer.parseInt(s.getStockNo()) > 50) {
			//throw new Exception("종목번호는 1부터 50까지입니당");
			System.out.println("종목번호는 1부터 50까지입니다");
			mainMenu();
		}
	}
	*/

	public void displayInsertSuccess(String message) {
		System.out.println(message);
	}
	public void displayInsertFail(String message) {
		System.out.println(message);
	}

	public void displayNoSelectData(String message) {
		System.out.println("\n" + message);
	}

	public void displayStockList(ArrayList<Stock> list) {
		System.out.println("\n 전체 종목 리스트입니다.");
		
		for (Stock m : list) { // m : list.get(0) => m : list.get(1)
			System.out.println(m);
		}

	}
	
}
