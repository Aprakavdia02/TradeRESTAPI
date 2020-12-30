package com.hackerrank.stocktrade;

import com.hackerrank.stocktrade.service.TradeDAO;
import com.hackerrank.stocktrade.service.TradeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {


    @Bean
    public TradeDAO getTradeDAO(){
        return new TradeDAO();
    }


    @Bean
    public TradeService getTradeService(){
        return new TradeService();
    }

}
