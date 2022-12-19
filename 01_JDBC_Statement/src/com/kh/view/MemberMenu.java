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
				//String userId = inputMemberId();
				//mc.selectByUserId(userId);
				mc.selectByUserId(inputMemberId());
				break;
			case 4:
				//String keyword = inputMemberName();
				//mc.selectByUserName(keyword);
				mc.selectByUserName(inputMemberName());
				break;
			case 5:
				updateMember();
				break;
			case 6:
				//String userId2 = inputMemberId();
				//mc.deleteMember(userId2);
				mc.deleteMember(inputMemberId());
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
	 * 사용자에게 회원 아이디 입력 받은 후 그때 입력된 값을 반환시켜주는 메소드
	 * @return 사용자가 입력한 값 
	 */
	public String inputMemberId() {
		System.out.print("\n 회원 아이디 입력 : ");
		return sc.nextLine();
	}

	/**
	 * 사용자에게 검색할 회원명(키워드) 입력 받은 후 그때 입력된 값을 반환시켜주는 메소드
	 * @return 사용자가 입력한 회원명(키워드)
	 */
	public String inputMemberName() {
		System.out.print("\n 회원 이름(키워드) 입력 : ");
		return sc.nextLine();
	}
	
	
	/**
	 * 사용자에게 변경할 정보들 (비번, 이메일, 전번, 주소)과 해당 회원 아이디 입력받는 화면
	 */
	public void updateMember() {
		System.out.println("\n=== 회원정보 변경 ===");
		
		// 비번, 이메일, 전화번호, 주소, 변경할 아이디!!
		/*
		System.out.print("회원정보를 변경할 회원아이디 입력 : ");
		String userId = sc.nextLine();
		*/
		String userId = inputMemberId(); // 위의 두 줄을 다음과같이 줄일 수 있음!
		
		System.out.print("변경할 암호 : ");
		String userPwd = sc.nextLine();
		
		System.out.print("변경할 이메일 : ");
		String email = sc.nextLine();

		System.out.print("변경할 전번 : ");
		String phone = sc.nextLine();

		System.out.print("변경할 주소 : ");
		String address = sc.nextLine();
		
		mc.updateMember(userId, userPwd, email, phone, address);
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
	 * 조회 서비스 요청시 조회결과가 없을 경우 사용자가 보게 될 응답화면
	 * 
	 * @param message
	 */
	public void displayNoData(String message) {
		System.out.println("\n" + message);
	}
	
	/**
	 *  조회 서비스 요청시 조회결과가 여러행일 경우 사용자가 보게될 응답화면
	 * 
	 * @param list
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
	 * 조회 서비스 요청시 조회결과가 한 행일 경우 사용자가 보게될 응답화면
	 * @param m
	 */
	public void displayMember(Member m) {
		System.out.println("\n 조회된 데이터는 다음과 같습니다.");
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

}
