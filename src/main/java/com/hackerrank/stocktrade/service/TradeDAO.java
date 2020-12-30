package com.hackerrank.stocktrade.service;

import com.hackerrank.stocktrade.model.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TradeDAO {

    @Autowired
    private JdbcTemplate jtm;

    public List<Trade> getAllTradesFromDAO(){
        return jtm.query("select * from TRADE",new BeanPropertyRowMapper<>(Trade.class));
    }

    public void addNewTrade(Trade trade) {
        String sql = "INSERT INTO TRADE VALUES (?, ?,?,?,?,?,?)";
        Object[] params = new Object[] {trade.getId(),trade.getType(),trade.getUser().toString(),trade.getSymbol(),trade.getShares(),trade.getPrice(),trade.getTimestamp()};

        jtm.update(sql, params);
    }

    public Trade getTradeByID(int id) {
        String query = "select * from TRADE where id = "+id;
        return (Trade) jtm.query(query,new BeanPropertyRowMapper<>(Trade.class));

    }

    public List<Trade> getTradeByUserID(int userID) {
        String query = "select * from TRADE where user_id = "+userID;
        return jtm.query(query,new BeanPropertyRowMapper<>(Trade.class));
    }

    public Trade getTradeByUserIDAndStockSymbol(int userID, int stockSymbol) {
        String query = "select * from TRADE where user_id = "+userID+" and symbol = "+stockSymbol;
        return (Trade) jtm.query(query,new BeanPropertyRowMapper<>(Trade.class));
    }

    public Trade getTradeByStockSymbol(int stockSymbol) {
        String query = "select * from TRADE where symbol = "+stockSymbol;
        return (Trade) jtm.query(query,new BeanPropertyRowMapper<>(Trade.class));
    }

    public void eraseAll() {
        String query = "Delete from trade where 1=1";
        jtm.execute(query);
    }
}
