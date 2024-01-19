package com.danishpinto.project1.portfolioapplication.controller;

import com.danishpinto.project1.portfolioapplication.DTO.TradeBean;
import com.danishpinto.project1.portfolioapplication.service.TradeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TradeController {

    private final TradeService tradeService;

    TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @PostMapping(path = "/trade")
    public void makeTransaction(@RequestBody TradeBean trade) {
        tradeService.makeTrade(trade);
    }
}
