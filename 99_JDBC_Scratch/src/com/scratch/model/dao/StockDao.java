package com.scratch.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.scratch.model.vo.Stock;

public class StockDao {

	public int insertStock(Stock s) {
		
		int result  = 0;
		Connection conn = null;
		Statement stmt = null;
		
		String sql = "INSERT INTO TB_STOCK VALUES(LPAD('"+s.getStockNo()+", 6, '0'), '"+s.getStockName()+"', '"+s.getMarket()+"', '"
				+s.getSector()+"', '"+s.getAddress()+"', '"+s.getEstDate()+"', '"+s.getCrapeDate()+"', "+s.getStockCount()+")";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCRATCH", "SCRATCH");
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			
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

	public ArrayList<Stock> selectList() {
		
		ArrayList<Stock> list = new ArrayList<>(); // 현재 상태는 텅 비어있는 상태

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null; // select문 실행시 조회된 결과값들이 최초로 담기는 객체
		
		String sql = "SELECT * FROM TB_STOCK";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCRATCH", "SCRATCH");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			while (rset.next()) {
				
				Stock s = new Stock();
				
				s.setStockNo(rset.getString("STOCKNO"));
				s.setStockName(rset.getString("STOCKNAME"));
				s.setMarket(rset.getString("MARKET"));
				s.setSector(rset.getString("SECTOR"));
				s.setAddress(rset.getString("ADDRESS"));
				s.setEstDate(rset.getString("EST_DATE"));
				s.setCrapeDate(rset.getString("CRAPE_DATE"));
				s.setStockCount(rset.getInt("STOCKCOUNT"));
				
				list.add(s);
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

}
