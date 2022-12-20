package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.model.vo.Member;


// DAO (Data Access Object) : DB에 직접적으로 접근해서 사용자의 요청에 맞는 SQL문 실행 후 결과받기 (JDBC)
//							  결과를 Controller로 다시 리턴
public class MemberDao {

	/*
	 * * Statement와 PreparedStatement의 특징
	 * - 둘다 sql문 실행하고 결과를 받아내는 객체(둘 중 하나 쓰면됨)
	 * 
	 * - Statement와 PreparedStatement의 차이점 
	 * - Statement 같은 경우는 sql문을 바로 전달하면서 실행시키는 객체
	 * (즉, sql문을 완성형태로 만들어 둬야됨!! 사용자가 입력한 값이 다 채워진 형태로!!)
	 * 
	 * 		> 기존의 Statement 방식
	 * 		1) Connection 객체를 통해 Statement 객체 생성 : stmt = conn.createStatement();
	 * 		2) Statement 객체를 통해 "완성된 sql문" 실행 및 결과 받기 : 결과 = stmt.executeXXX(완성된 SQL);
	 * 
	 * - PreparedStatement 같은 경우 "미완성된 sql"문을 잠시 보관해둘 수 있는 객체
	 * (즉, 사용자가 입력한 값들을 채워두지 않고 각각 들어갈 공간을 확보만 미리 해놓아도 됨!)
	 * 단, 해당 sql문 본격적으로 실행하기 전에는 빈 공간을 사용자가 입력한 값으로 채워서 실행하긴 해야함
	 * 
	 * 		> PreparedStatement 방식
	 * 		1) Connection 객체를 통해 PreparedStatement 객체 생성 : pstmt = conn.preparedStatement([미완성]sql문);
	 * 		2) 미완성 상태인 SQL문을 완성시켜야함 					 : pstmt.setXXX(1, "대체할 값");
	 * 		3) 해당 완성된 SQL문 실행 결과받기						 : 결과 = pstmt.executeXXX
	 * 
	 * 
	 */
	
	/**
	 * 회원 추가하는 메소드
	 * @param m
	 * @return
	 */
	public int insertMember(Member m) {
		// insert문 => 처리된행수 (int) => 트랜젝션 처리
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		// 실행할 sql문 (미완성된 형태로 둘 수 있음)
		// INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, 'XXX', 'XXX', 'XXX', 'X', XX,
		// 'XXXX', 'XXXXXX', 'XXXX', 'XXXX', SYSDATE)
		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		
		try {
			// 1) jdbc 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2) Connection 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","JDBC","JDBC");
			// 3) PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql); // 애초에 pstmt 객체 생성시 sql문 담은채로 생성! (지금은 미완성)
			// 빈공간을 실제값(사용자가 입력한 값)으로 채워준 후 실행
			// pstmt.setString(홀더순번, 대체할값)		=> '대체할값' (홑따옴표 감싸준 상태로 알아서 들어감)
			// pstmt.setInt(홀더순번, 대체할값)			=> 대체할값
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
			
			
			
			// 4, 5) sql문 실행 및 결과 받기
			result = pstmt.executeUpdate(); // 여기서는 sql문 전달하지 않고 그냥 실행해야함!! 이미 pstmt에 sql이 들어가있음!!
			
			if(result > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public ArrayList<Member> selectList() {
		// select문 (여러행) => ResultSet객체 => ArrayList
		ArrayList<Member> list = new ArrayList<Member>(); // 텅빈 리스트
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			pstmt = conn.prepareStatement(sql); // 애초에 완성된 sql문 담았음!
			
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				//현재 rset이 참조하고있는 해당 행의 모든 컬럼값 뽑아서 => 한 Member 객체에 담기 => 리스트 차곡차곡 추가
				list.add(new Member(rset.getInt("userno"),
									rset.getString("userid"),
									rset.getString("userpwd"),
									rset.getString("username"),
									rset.getString("gender"),
									rset.getInt("age"),
									rset.getString("email"),
									rset.getString("phone"),
									rset.getString("address"),
									rset.getString("hobby"),
									rset.getDate("enrolldate")
									));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	public Member selectByUserId(String userId) {
		
		Member m = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USERID = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				m = new Member(rset.getInt("userno"),
						rset.getString("userid"),
						rset.getString("userpwd"),
						rset.getString("username"),
						rset.getString("gender"),
						rset.getInt("age"),
						rset.getString("email"),
						rset.getString("phone"),
						rset.getString("address"),
						rset.getString("hobby"),
						rset.getDate("enrolldate")
					);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return m;
				
	}

	public ArrayList<Member> selectbyUserName(String userName) {
		
		ArrayList<Member> list = new ArrayList<Member>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USERNAME LIKE ?";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+userName+"%");
			
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				
				list.add(new Member(rset.getInt("userno"),
						rset.getString("userid"),
						rset.getString("userpwd"),
						rset.getString("username"),
						rset.getString("gender"),
						rset.getInt("age"),
						rset.getString("email"),
						rset.getString("phone"),
						rset.getString("address"),
						rset.getString("hobby"),
						rset.getDate("enrolldate")
						));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	public int updateMember(Member m) {
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MEMBER SET USERPWD = ?, EMAIL = ?, PHONE = ?, ADDRESS = ? WHERE USERID = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","JDBC","JDBC");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserPwd());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getUserId());
			
			result = pstmt.executeUpdate();
			
			if (result > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}

	public int deleteMember(String userId) {
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM MEMBER WHERE USERID = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC" , "JDBC");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}

	public Member loginMember(Member m) {
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT userId FROM MEMBER WHERE USERID = ? AND USERPWD = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				
				m = new Member (rset.getString("userId"));
				
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}


	
	
	
	
	
	
	
	
	
	
	
}
