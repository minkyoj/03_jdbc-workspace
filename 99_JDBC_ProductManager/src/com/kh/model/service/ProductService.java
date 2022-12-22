package com.kh.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.kh.common.JDBCTemplate.*;

import com.kh.model.dao.ProductDao;
import com.kh.model.vo.Product;

public class ProductService {

	public ArrayList<Product> selectList() {
		
		Connection conn = getConnection();
		
		ArrayList<Product> list = new ProductDao().selectList(conn);
		
		close(conn);
		
		return list;
	}

	public int inputProduct(Product p) {

		Connection conn = getConnection();

		int result = new ProductDao().inputProduct(conn, p);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		return result;
	}

	public int updateProduct(Product p) {
		
		Connection conn = getConnection();

		int result = new ProductDao().updateProduct(conn, p);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public int deleteProduct(String productId) {
		
		Connection conn = getConnection();

		int result = new ProductDao().deleteProduct(conn, productId);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public ArrayList<Product> selectByPname(String pName) {
		Connection conn = getConnection();

		ArrayList<Product> list = new ProductDao().selectByPname(conn, pName);

		close(conn);

		return list;
	}

}
