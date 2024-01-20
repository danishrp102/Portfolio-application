package com.danishpinto.project1.portfolioapplication.service;

import com.danishpinto.project1.portfolioapplication.DTO.HoldingsDTO;
import com.danishpinto.project1.portfolioapplication.DTO.PortfolioDTO;
import com.danishpinto.project1.portfolioapplication.entity.Stock;
import com.danishpinto.project1.portfolioapplication.entity.TradedStock;
import com.danishpinto.project1.portfolioapplication.entity.User;
import com.danishpinto.project1.portfolioapplication.exception.UserNotFoundException;
import com.danishpinto.project1.portfolioapplication.repository.StockRepository;
import com.danishpinto.project1.portfolioapplication.repository.TradedStockRepository;
import com.danishpinto.project1.portfolioapplication.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    TradedStockRepository tradedStockRepository;

    @Transactional()
    public PortfolioDTO getAllHoldings(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()) {
            throw new UserNotFoundException("userId: " + userId);
        }

        List<HoldingsDTO> holdingsDTOList = new ArrayList<>();

        Double totalBuyPrice = (double) 0;
        BigDecimal tempTotalPortfolioHolding = new BigDecimal(0);
        Double totalProfitOrLoss = (double) 0;

        List<TradedStock> tradedStockList = user.get().getTradedStocks();
        for(int i = 0; i < tradedStockList.size(); i++) {
            String stockId = tradedStockList.get(i).getStockId();
            Optional<Stock> stock = stockRepository.findById(stockId);
            String stockName = stock.get().getName();
            Long quantity = tradedStockList.get(i).getQuantity();
            Double buyPrice = tradedStockList.get(i).getTotalBuyPrice() / tradedStockList.get(i).getQuantity().doubleValue();
            Double currentPrice = stock.get().getClosePrice();
            Double gainOrLoss = currentPrice - buyPrice;

            totalBuyPrice += buyPrice;
            totalProfitOrLoss += gainOrLoss;

            BigDecimal quantityBigDecimal = new BigDecimal(Double.toString(quantity));
            BigDecimal buyPriceBigDecimal = new BigDecimal(Double.toString(buyPrice));
            tempTotalPortfolioHolding = tempTotalPortfolioHolding.add(quantityBigDecimal.multiply(buyPriceBigDecimal));

            HoldingsDTO holdingsDTO = new HoldingsDTO(stockName, stockId, quantity, buyPrice, currentPrice, gainOrLoss);
            holdingsDTOList.add(holdingsDTO);
        }

        Double totalPortfolioHolding = tempTotalPortfolioHolding.doubleValue();
        Double totalProfitOrLossPercentage = (totalProfitOrLoss / totalBuyPrice) * 100;
        return new PortfolioDTO(holdingsDTOList, totalPortfolioHolding, totalBuyPrice, totalProfitOrLossPercentage);
    }
}
