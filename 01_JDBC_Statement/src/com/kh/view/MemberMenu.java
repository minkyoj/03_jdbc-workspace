package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.MemberController;
import com.kh.model.vo.Member;

// View : 사용자가 보게 될 시각적인 요소(화면) 출력 및 입력

public class MemberMenu {

	// Scanner 객체 생성 (전역으로 다 쓸 수 있도록)
	private Scanner sc = new Scanner(System.in);

	// MemberController 객체 생성 (전역에서 바로 요청할 수 있게끔)
	private MemberController mc = new MemberController();

	// alt+shift+j 파란주석
	/**
	 * 사용자가 보게될 첫 화면 (메인화면)
	 */
	public void mainMenu() { // -- mainMenu start

		while (true) { // -- while start

			System.out.println("\n   == 회원관리 프로그램 ==");
			System.out.println("┌───────────────────────────────┐");
			System.out.println("│ 1) 회원 추가   \t\t\t│");
			System.out.println("│ 2) 회원전체조회   \t\t│");
			System.out.println("│ 3) 회원 아이디 검색\t\t│");
			System.out.println("│ 4) 회원 이름으로 키워드 검색   \t│");
			System.out.println("│ 5) 회원 정보 변경   \t\t│");
			System.out.println("│ 6) 회원탈퇴   \t\t\t│");
			System.out.println("│ 9) 이름으로 정보조회   \t\t│");
			System.out.println("│ 0) 프로그램 종료   \t\t│");
			System.out.println("└───────────────────────────────┘");
			System.out.print(">> 메뉴 선택 : ");
			int menu = sc.nextInt();

			sc.nextLine();

			switch (menu) {
			case 1:
				inputMember();
				break;
			case 2:
				mc.selectList();
				break; // 입력받을 거 없으면 바로 Controller 호출
			case 3:
				searchMemberId();
				break;
			case 4:
				searchKeywordName();
				break;
			case 5:
				updateMember();
				break;
			case 6:
				deleteMember();
				break;
			case 9:
				searchMemberName();
				break;
			case 0:
				System.out.println("이용해주셔서 감사합니다.");
				return;
			default:
				System.out.println("메뉴를 잘못입력하셨습니다. 다시입력해주세요.");

			}
		} // -- while end
	} // -- mainMenu start

	/**
	 * 회원 추가 화면(서브화면) -- case 1 즉, 추가하고자 하는 회원의 정보를 입력 받아서 회원 추가요청하는 창
	 */
	public void inputMember() {
		System.out.println("\n==== 회원추가 ====");
		// 아이디 ~ 취미까지 입력 받기

		System.out.print("아이디 : ");
		String userId = sc.nextLine();

		System.out.print("비밀번호 : ");
		String userPwd = sc.nextLine();

		System.out.print("이름 : ");
		String userName = sc.nextLine();

		System.out.print("성별(M/F) : ");
		String gender = sc.nextLine();

		System.out.print("나이 : "); // 이제부터 문자열로 다 받자! 웹에서는 다 문자로 넘어옴!
		String age = sc.nextLine(); // "19"

		System.out.print("이메일 : ");
		String email = sc.nextLine();

		System.out.print("전화번호(- 빼고 입력) : ");
		String phone = sc.nextLine();

		System.out.print("주소 : ");
		String address = sc.nextLine();

		System.out.print("취미(,로 공백없이 연이어서 작성) : ");
		String hobby = sc.nextLine();

		// 회원 추가 요청 == Controller 메소드 호출
		mc.insertMember(userId, userPwd, userName, gender, age, email, phone, address, hobby);

	}

	/**
	 * 이름검색 화면(서브화면) -- case 9 찾고자하는 회원의 이름을 입력 받는 창
	 */
	private void searchMemberName() {
		System.out.print("이름 : ");
		String userName = sc.nextLine();

		mc.searchMemberName(userName);
	}

	/**
	 * 아이디검색 화면(서브화면) -- case 3 찾고자하는 회원의 아이디를 입력 받는 창
	 */
	private void searchMemberId() {
		System.out.print("아이디 : ");
		String userId = sc.nextLine();

		mc.searchMemberId(userId);
	}

	/**
	 * 이름검색 화면(서브화면) -- case 4 찾고자하는 회원의 이름을 입력 받는 창
	 */
	private void searchKeywordName() {
		System.out.print("이름 : ");
		String userName = sc.nextLine();

		mc.searchKeywordName(userName);
	}

	/**
	 * 수정값 입력 화면(서브화면) -- case 5 수정할 회원의 정보를 입력 받는 창
	 */
	private void updateMember() {
		System.out.print("변경할 아이디 : ");
		String userId = sc.nextLine();

		System.out.print("이름 수정 : ");
		String userName = sc.nextLine();

		System.out.print("성별 수정 : ");
		String gender = sc.nextLine();

		System.out.print("나이 수정 : ");
		String age = sc.nextLine();

		System.out.print("이메일 수정 : ");
		String email = sc.nextLine();

		System.out.print("휴대폰번호 수정 : ");
		String phone = sc.nextLine();

		System.out.print("주소 수정 : ");
		String address = sc.nextLine();

		System.out.print("취미 수정 : ");
		String hobby = sc.nextLine();

		mc.updateMember(userId, userName, gender, age, email, phone, address, hobby);
	}
	
	
	/**
	 * 삭제할 아이디 검색 화면(서브화면) -- case 6 삭제할 회원의 아이디를 입력 받는 창
	 */
	private void deleteMember() {
		System.out.print("삭제할 아이디 : ");
		String userId = sc.nextLine();
		
		mc.updateDelete(userId);
	}

	// ------------------------------------------ 응답 화면
	// ----------------------------------------------

	/**
	 * 서비스 요청 처리 후 성공했을 경우 사용자가 보게 될 응답화면 -- case 1
	 * 
	 * @param message 성공메세지
	 */
	public void displaySuccess(String message) {
		System.out.println("\n 서비스 요청 성공 : " + message);
	}

	/**
	 * 서비스 요청 처리 후 실패했을 경우 사용자가 보게 될 응답화면 -- case 1
	 * 
	 * @param message 실패메세지
	 */
	public void displayFail(String message) {
		System.out.println("\n 서비스 요청 실패 : " + message);
	}

	/**
	 * 조회 서비스 요청시 조회결과가 없을 경우 사용자가 보게 될 응답화면 -- case 2
	 * 
	 * @param message
	 */
	public void displayNoData(String message) {
		System.out.println("\n" + message);
	}

	/**
	 * 조회 서비스 요청시 조회결과가 있는 경우 사용자가 보게 될 응답화면 -- case 2
	 * 
	 * @param message
	 */
	public void displayMemberList(ArrayList<Member> list) {
		System.out.println("\n 조회된 데이터는 다음과 같습니다.");

		// 단순 for문
		/*
		 * for(int i=0; i<list.size()-1; i++) { System.out.println(list.get(i)); }
		 */

		// 향상된 for문 (For Each문)
		for (Member m : list) { // m : list.get(0) => m : list.get(1)
			System.out.println(m);
		}

	}

	/**
	 * 이름 검색 서비스 요청시 조회결과가 없을 경우 사용자가 보게 될 응답화면 -- case 9
	 * 
	 * @param string
	 */
	public void displayNoDataName(String message) {
		System.out.println("\n" + message);
	}

	/**
	 * 이름 검색 서비스 요청시 조회결과가 있을 경우 사용자가 보게 될 응답화면 -- case 9
	 * 
	 * @param string
	 */
	public void displayNameMemberList(ArrayList<Member> list) {
		System.out.println("\n 조회된 데이터는 다음과 같습니다.");
		ArrayList<Member> m = list;
		System.out.println(m);
	}

	/**
	 * 아이디 검색 서비스 요청시 조회결과가 있을 경우 사용자가 보게 될 응답화면 -- case 3
	 * 
	 * @param string
	 */
	public void displayNoDataId(String message) {
		System.out.println("\n" + message);
	}

	/**
	 * 아이디 검색 서비스 요청시 조회결과가 있을 경우 사용자가 보게 될 응답화면 -- case 3
	 * 
	 * @param string
	 */
	public void displayIdMemberList(ArrayList<Member> list) {
		System.out.println("\n 조회된 데이터는 다음과 같습니다.");
		ArrayList<Member> m = list;
		System.out.println(m);
	}

	/**
	 * 아이디 검색 서비스 요청시 조회결과가 있을 경우 사용자가 보게 될 응답화면 -- case 4
	 * 
	 * @param string
	 */
	public void displayNoDataKeywordName(String message) {
		System.out.println("\n" + message);
	}

	/**
	 * 아이디 검색 서비스 요청시 조회결과가 있을 경우 사용자가 보게 될 응답화면 -- case 4
	 * 
	 * @param string
	 */
	public void displayKeywordNameMemberList(ArrayList<Member> list) {
		System.out.println("\n 조회된 데이터는 다음과 같습니다.");
		ArrayList<Member> m = list;
		System.out.println(m);
	}

	/**
	 * 수정 서비스 요청시 조회결과가 있을 경우 사용자가 보게 될 응답화면 -- case 5
	 * 
	 * @param string
	 */
	public void displayUpdateSuccess(String message) {
		System.out.println(message);
	}

	/**
	 * 수정 서비스 요청시 조회결과가 있을 경우 사용자가 보게 될 응답화면 -- case 5
	 * 
	 * @param string
	 */
	public void displayUpdateFail(String message) {
		System.out.println(message);
	}

}
