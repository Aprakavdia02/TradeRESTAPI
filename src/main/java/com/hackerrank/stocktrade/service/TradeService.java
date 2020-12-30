package com.hackerrank.stocktrade.service;


import com.hackerrank.stocktrade.model.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeService {


    @Autowired
    TradeDAO tradeDAO;

    public void getAllTrades(){
        List<Trade> tradeList = tradeDAO.getAllTradesFromDAO();
    }

    public void addNew(Trade trade){
        try {
            tradeDAO.addNewTrade(trade);
        }catch (Exception e){
            throw e;
        }
    }

    public Trade byID(int id){
        try {
            return tradeDAO.getTradeByID(id);
        }catch (Exception e){
            throw e;
        }
    }

    public   List<Trade>  byUserID(int userID){
        try {
            return tradeDAO.getTradeByUserID(userID);
        }catch (Exception e){
            throw e;
        }
    }

    public Trade byUserIDAndStockSymbol(int userID, int stockSymbol){
        try {
            return tradeDAO.getTradeByUserIDAndStockSymbol(userID,stockSymbol);
        }catch (Exception e){
            throw e;
        }
    }

    public Trade byStockSymbol(int stockSymbol){
        try {
            return tradeDAO.getTradeByStockSymbol(stockSymbol);
        }catch (Exception e){
            throw e;
        }
    }

    public void earse() {
        tradeDAO.eraseAll();
    }
}
