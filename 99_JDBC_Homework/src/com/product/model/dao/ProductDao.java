package com.product.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.product.model.vo.Product;

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
		
		
		
		
		return null;
	}

}
