package test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestRun {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		int result = 0;
		String sql = null;
		int num = 0;
		boolean dml = true;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			stmt = conn.createStatement();

			while (true) {
				System.out.println("============메뉴선택==============");
				System.out.println("1. SELECT");
				System.out.println("2. INSERT");
				System.out.println("3. DELETE");
				System.out.println("4. UPDATE");
				System.out.println("5. 종료");
				System.out.println("===============================");
				System.out.print("메뉴번호를 입력해주세요 : ");
				Scanner sc = new Scanner(System.in);
				int menu = sc.nextInt();
				sc.nextLine();
				switch (menu) {

				case 1: // SELECT
					sql = "SELECT * FROM PRODUCT ORDER BY PNO ASC";
					rset = stmt.executeQuery(sql);
					while (rset.next()) {
						int pno = rset.getInt("PNO");
						String pname = rset.getString("PNAME");
						int price = rset.getInt("PRICE");
						Date pdate = rset.getDate("REG_DATE");
						System.out.println("번호 : " + pno + ", 상품명 : " + pname + ", 가격 : " + price + ", 등록일 : " + pdate);
					}
					dml = false;
					break;

				case 2: // INSERT
					System.out.print("이름 : ");
					String name = sc.next();
					System.out.print("가격 : ");
					int price = sc.nextInt();
					sql = "INSERT INTO PRODUCT VALUES(SEQ_PNO.NEXTVAL, '" + name + "', " + price + ", SYSDATE)";
					dml = true;
					break;

				case 3: // DELETE
					System.out.print("삭제할 상품의 번호 : ");
					num = sc.nextInt();
					sc.nextLine();
					sql = "DELETE FROM PRODUCT WHERE PNO = " + num;
					dml = true;
					break;

				case 4: // UPDATE
					System.out.print("수정할 상품의 번호 : ");
					num = sc.nextInt();
					sc.nextLine();

					System.out.println("1. 상품명 수정");
					System.out.println("2. 가격 수정");
					System.out.print("메뉴번호 입력 : ");
					int uNum = sc.nextInt();

					sc.nextLine();

					if (uNum == 1) {
						System.out.print("새로운 상품명 입력 : ");
						String str = sc.nextLine();
						sql = "UPDATE PRODUCT SET PNAME = '" + str + "'" + "WHERE PNO = " + num;
					} else if (uNum == 2) {
						System.out.print("새로운 가격 입력 : ");
						int nPrice = sc.nextInt();
						sql = "UPDATE PRODUCT SET PRICE = " + nPrice + "WHERE PNO = " + num;
					}
					dml = true;
					break;

				case 5: // EXIT
					System.out.println("종료합니다.");
					return;
				}
				if (dml == true) {
					result = stmt.executeUpdate(sql);
					if (result > 0) {
						System.out.println("DML 성공");
						conn.commit();
					} else {
						System.out.println("DML 실패");
						conn.rollback();
						break;
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
