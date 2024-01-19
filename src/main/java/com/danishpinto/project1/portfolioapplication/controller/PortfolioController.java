package com.danishpinto.project1.portfolioapplication.controller;

import com.danishpinto.project1.portfolioapplication.DTO.PortfolioDTO;
import com.danishpinto.project1.portfolioapplication.service.PortfolioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/portfolio")
public class PortfolioController {
    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping(path = "{userId}")
    public PortfolioDTO getHoldingsOfUser(@PathVariable("userId") Integer userId) {
        return portfolioService.getAllHoldings(userId);
    }
}
