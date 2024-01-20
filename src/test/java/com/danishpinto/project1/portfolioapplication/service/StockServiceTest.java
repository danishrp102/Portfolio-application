package com.danishpinto.project1.portfolioapplication.service;
import com.danishpinto.project1.portfolioapplication.entity.Stock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext
@TestPropertySource(locations = "classpath:application-test.properties")
public class StockServiceTest {
    @Autowired
    StockService stockService;

    @Test
//    @Sql("classpath:data.sql")
    @Sql("classpath:test_script_stock.sql")
    public void getAllStocks() {
        Stock firstStock = stockService.retreiveStock("101");
        assertEquals("Groww", firstStock.getName());
        assertEquals(1200, firstStock.getOpenPrice());
        assertEquals(1400, firstStock.getHighPrice());
        assertEquals(900, firstStock.getLowPrice());
        assertEquals(1150, firstStock.getClosePrice());
        assertEquals(950, firstStock.getSettlementPrice());

        Stock secondStock = stockService.retreiveStock("102");
        assertEquals("Adobe", secondStock.getName());
        assertEquals(250, secondStock.getOpenPrice());
        assertEquals(400, secondStock.getHighPrice());
        assertEquals(250, secondStock.getLowPrice());
        assertEquals(300, secondStock.getClosePrice());
        assertEquals(350, secondStock.getSettlementPrice());

        Stock thirdStock = stockService.retreiveStock("103");
        assertEquals("IBM", thirdStock.getName());
        assertEquals(1600, thirdStock.getOpenPrice());
        assertEquals(1900, thirdStock.getHighPrice());
        assertEquals(1500, thirdStock.getLowPrice());
        assertEquals(1550, thirdStock.getClosePrice());
        assertEquals(1650, thirdStock.getSettlementPrice());
    }
}



