package com.scratch.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.scratch.model.dao.StockDao;
import com.scratch.model.vo.Stock;
import com.scratch.view.StockMenu;

public class StockController {


	/*
	public void insertStock(String stockNo, String stockName, String market, String sector, String address,
			String estDate, String crapeDate, String stockCount) {
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

			Date eDate = sdf.parse(estDate);
			Date cDate = sdf.parse(crapeDate);

			Stock s = new Stock(stockNo, stockName, market, sector, address, eDate, cDate, Integer.parseInt(stockCount));
			
			int result = new StockDao().insertStock(s);

			if (result > 0) {
				new StockMenu().displayInsertSuccess("종목이 성공적으로 추가되었습니다.");
			} else {
				new StockMenu().displayInsertFail("종목 추가 실패하였습니다.");
			}

		} catch (ParseException e) {
			e.printStackTrace();
		} 
	}
	*/
	
	public void insertStock(String stockNo, String stockName, String market, String sector, String address,
			String estDate, String crapeDate, String stockCount) {
		
		Stock s = new Stock(stockNo, stockName, market, sector, address, estDate, crapeDate, Integer.parseInt(stockCount));
		
		int result = new StockDao().insertStock(s);
		
		if (result > 0) {
			new StockMenu().displayInsertSuccess("종목이 성공적으로 추가되었습니다.");
		} else {
			new StockMenu().displayInsertFail("종목 추가 실패하였습니다.");
		}
		
	}

	public void selectList() {
		
		ArrayList<Stock> list = new StockDao().selectList();
		
		if (list.isEmpty()) {
			new StockMenu().displayNoSelectData("전체 조회 결과가 없습니다.");
		} else {
			new StockMenu().displayStockList(list);
		}
		
	}
	
}
