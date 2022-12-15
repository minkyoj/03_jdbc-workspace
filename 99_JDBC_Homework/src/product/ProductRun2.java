package product;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * * JDBC 실습(중복코드 제거 ver)
 * 
 * @author jmk
 * @since 2022.12.15
 *
 */

public class ProductRun2 {

	public static void main(String[] args) {

		// 사용할 객체 및 변수 셋팅

		// 스캐너
		Scanner sc = new Scanner(System.in);

		// JDBC 객체
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		// 일반변수
		String pname = null;
		String sql = null;
		String type = null;

		int result = 0;
		int price = 0;

		boolean dml = true;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");

			stmt = conn.createStatement();

			while (true) { // -- while start

				// 메뉴 출력 및 선택
				System.out.println("JDBC 메뉴");
				System.out.println("1. SELECT 조회");
				System.out.println("2. INSERT 추가");
				System.out.println("3. DELETE 삭제");
				System.out.println("4. 종료");

				System.out.print(">> 메뉴를 선택해주세요 : ");
				int menu = sc.nextInt();

				sc.nextLine();

				if (menu == 1) { // SELECT
					dml = false;
					sql = "SELECT * FROM PRODUCT ORDER BY PNO";
				} else if (menu == 2) { // insert
					dml = true;
					type = "insert";
					System.out.print("상품명 입력 : ");
					pname = sc.nextLine();
					System.out.print("상품가격 입력 : ");
					price = sc.nextInt();

					sc.nextLine();

					sql = "INSERT INTO PRODUCT VALUES(SEQ_PNO.NEXTVAL, '" + pname + "'," + price + ", SYSDATE)";
				} else if (menu == 3) {
					dml = true;
					type = "delete";
					System.out.println("상품명 입력 : ");
					pname = sc.nextLine();
					sql = "DELETE FROM PRODUCT WHERE PNAME LIKE '%" + pname + "%'"; // 해당 키워드에 해당하면 전부 삭제

				} else if (menu == 4) {
					System.out.println("시스템을 종료합니다.");
					return;
				}
				if (dml) {
					result = stmt.executeUpdate(sql);
					if (result > 0) {
						conn.commit();
						System.out.println(type + " 성공");
					} else {
						conn.rollback();
						System.out.println(type + " 실패");
					}
				} else { // dml이 false => select
					rset = stmt.executeQuery(sql);
					while (rset.next()) {
						int pno = rset.getInt("PNO");
						pname = rset.getString("PNAME");
						price = rset.getInt("PRICE");
						Date regdate = rset.getDate("REG_DATE");
						System.out.println(pno + ", " + pname + ", " + price + ", " + regdate);
					}
				}
			} // -- while end
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		}
	}
}
