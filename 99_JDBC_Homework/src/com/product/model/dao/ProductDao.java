package com.product.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.product.model.vo.Product;
import com.product.view.ProductMenu;

public class ProductDao {

	public int inputProduct(Product p) {

		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO TB_PRODUCT VALUES(SEQ_PNO.NEXTVAL, ?, ?, ?, ?, ?, ?, SYSDATE)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, p.getpName());
			pstmt.setInt(2, p.getPrice());
			pstmt.setString(3, p.getNational());
			pstmt.setString(4, p.getBrand());
			pstmt.setString(5, p.getSsgAble());
			pstmt.setString(6, p.getCategory());
			
			result = pstmt.executeUpdate();

			if (result > 0) {
				conn.commit();
			} else {
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

	public ArrayList<Product> selectList() {
		
		ArrayList<Product> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM TB_PRODUCT";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				
				Product p = new Product();
				
				p.setpNO(rset.getInt("pNo"));
				p.setpName(rset.getString("pName"));
				p.setPrice(rset.getInt("price"));
				p.setNational(rset.getString("national"));
				p.setBrand(rset.getString("brand"));
				p.setSsgAble(rset.getString("ssg_Able"));
				p.setCategory(rset.getString("category"));
				p.setRegDate(rset.getDate("reg_Date"));
				
				list.add(p);
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

	public ArrayList<Product> selectByPname(String keyword) {
		
		ArrayList<Product> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM TB_PRODUCT WHERE PNAME LIKE ?";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+keyword+"%");
			
			rset = pstmt.executeQuery();
			
			while (rset.next()) {

				Product p = new Product();

				p.setpNO(rset.getInt("pNo"));
				p.setpName(rset.getString("pName"));
				p.setPrice(rset.getInt("price"));
				p.setNational(rset.getString("national"));
				p.setBrand(rset.getString("brand"));
				p.setSsgAble(rset.getString("ssg_Able"));
				p.setCategory(rset.getString("category"));
				p.setRegDate(rset.getDate("reg_Date"));

				list.add(p);
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

	public int updateProduct(Product p) {
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE TB_PRODUCT SET price = ?, ssg_Able = ? WHERE pNAME = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, p.getPrice());
			pstmt.setString(2, p.getSsgAble());
			pstmt.setString(3, p.getpName());
			
			result = pstmt.executeUpdate();
			
			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int deleteProduct(String pName) {
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM TB_PRODUCT WHERE pName = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pName);
			
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
		}
		
		return result;
	}

	public ArrayList<Product> selectSsgProduct() {
		
		ArrayList<Product> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM TB_PRODUCT WHERE ssg_Able='Y'";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				
				Product p = new Product();

				p.setpNO(rset.getInt("pNo"));
				p.setpName(rset.getString("pName"));
				p.setPrice(rset.getInt("price"));
				p.setNational(rset.getString("national"));
				p.setBrand(rset.getString("brand"));
				p.setSsgAble(rset.getString("ssg_Able"));
				p.setCategory(rset.getString("category"));
				p.setRegDate(rset.getDate("reg_Date"));

				list.add(p);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public ArrayList<Product> selectPriceProduct(int minPrice, int maxPrice) {

		ArrayList<Product> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = "SELECT * FROM TB_PRODUCT WHERE PRICE >= ? AND PRICE <= ?";

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, minPrice);
			pstmt.setInt(2, maxPrice);
			
			rset = pstmt.executeQuery();

			while (rset.next()) {

				Product p = new Product();

				p.setpNO(rset.getInt("pNo"));
				p.setpName(rset.getString("pName"));
				p.setPrice(rset.getInt("price"));
				p.setNational(rset.getString("national"));
				p.setBrand(rset.getString("brand"));
				p.setSsgAble(rset.getString("ssg_Able"));
				p.setCategory(rset.getString("category"));
				p.setRegDate(rset.getDate("reg_Date"));

				list.add(p);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
