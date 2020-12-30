package com.hackerrank.stocktrade.controller;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/trades")
public class TradesController {

    @Autowired
    TradeService tradeService;

    @PostMapping("")
    public void addNewTrades(@RequestBody Trade trade){
        tradeService.addNew(trade);
    }

    @GetMapping("/{id}")
    public void tradeByID(@PathVariable int id){
        tradeService.byID(id);
    }

    @GetMapping("/")
    public void allTrades(){
        tradeService.getAllTrades();
    }

    @GetMapping("/users/{userID}")
    public void tradesByUserID(@PathVariable int userID){
        tradeService.byUserID(userID);
    }

    @GetMapping("/stocks/{stockSymbol}")
    public void tradesByStockSymbol(@PathVariable int stockSymbol){
        tradeService.byStockSymbol(stockSymbol);
    }

    @GetMapping("/user/{userID}/stocks/{stockSymbol}")
    public void tradesByUserIDAndStockSymbol(@PathVariable int userID,@PathVariable int stockSymbol){
        tradeService.byUserIDAndStockSymbol(userID,stockSymbol);
    }
}
