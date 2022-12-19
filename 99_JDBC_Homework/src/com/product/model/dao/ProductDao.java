package com.product.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
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
		Statement stmt = null;

		String sql = "INSERT INTO TB_PRODUCT VALUES(SEQ_PNO.NEXTVAL, '" + p.getpName() + "',"
																	+ p.getPrice() + ","
															+ 	"'" + p.getNational() + "',"
															+ 	"'" + p.getBrand() + "',"
															+ 	"'" + p.getSsgAble() + "',"
															+ 	"'" + p.getCategory() + "', SYSDATE)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);

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
				stmt.close();
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
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM TB_PRODUCT";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
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
				stmt.close();
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
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM TB_PRODUCT WHERE PNAME LIKE '%"+keyword+"%'";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
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

	public int updateProduct(String pName, int price, String ssgAble) {
		
		int result = 0;
		
		Connection conn = null;
		Statement stmt = null;
		
		String sql = "UPDATE TB_PRODUCT SET price ="  		+ price 	+ ","
									+	"ssg_Able ='" 		+ ssgAble	+ "'"
									+	"WHERE pName = '"	+ pName	+ "'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			
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
		Statement stmt = null;
		
		String sql = "DELETE FROM TB_PRODUCT WHERE pName = '" + pName + "'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(sql);
			
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
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM TB_PRODUCT WHERE ssg_Able='Y'";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
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
