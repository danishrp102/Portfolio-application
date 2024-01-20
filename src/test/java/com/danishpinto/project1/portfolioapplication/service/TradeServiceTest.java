package com.danishpinto.project1.portfolioapplication.service;

import com.danishpinto.project1.portfolioapplication.DTO.HoldingsDTO;
import com.danishpinto.project1.portfolioapplication.DTO.PortfolioDTO;
import com.danishpinto.project1.portfolioapplication.DTO.TradeBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext
@TestPropertySource(locations = "classpath:application-test.properties")
public class TradeServiceTest {

    @Autowired
    TradeService tradeService;

    @Autowired
    PortfolioService portfolioService;

    @Test
//    @Sql("classpath:data.sql")
    void buyAndSellTest() {
        tradeService.makeTrade(new TradeBean(1, "101", "buy", 5L));
        PortfolioDTO portfolioDTO = portfolioService.getAllHoldings(1);

         List<HoldingsDTO> holdingsDTOList = portfolioDTO.getHoldingsList();
         assertEquals(1, holdingsDTOList.size());
         assertEquals(5750.0, portfolioDTO.getTotalPortfolioHolding());
         assertEquals(1150.0, portfolioDTO.getTotalBuyPrice());

         for(int i = 0; i < holdingsDTOList.size(); i++) {
            if(holdingsDTOList.get(i).getStockId().equals("101")) {
                assertEquals(5L, holdingsDTOList.get(i).getQuantity());
                assertEquals("Groww", holdingsDTOList.get(i).getStockName());
            }
         }

         tradeService.makeTrade(new TradeBean(1, "101", "sell", 2L));
         PortfolioDTO sellPortfolioDTO = portfolioService.getAllHoldings(1);
        List<HoldingsDTO> sellholdingsDTOList = sellPortfolioDTO.getHoldingsList();
        assertEquals(1, sellholdingsDTOList.size());
        assertEquals(3450.0, sellPortfolioDTO.getTotalPortfolioHolding());
        assertEquals(1150.0, sellPortfolioDTO.getTotalBuyPrice());

        for(int i = 0; i < sellholdingsDTOList.size(); i++) {
            if(sellholdingsDTOList.get(i).getStockId().equals("101")) {
                assertEquals(3L, sellholdingsDTOList.get(i).getQuantity());
                assertEquals("Groww", sellholdingsDTOList.get(i).getStockName());
            }
        }


    }
}


