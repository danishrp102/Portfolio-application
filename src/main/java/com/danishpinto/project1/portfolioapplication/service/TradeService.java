package com.danishpinto.project1.portfolioapplication.service;

import com.danishpinto.project1.portfolioapplication.DTO.TradeBean;
import com.danishpinto.project1.portfolioapplication.entity.Stock;
import com.danishpinto.project1.portfolioapplication.entity.TradedStock;
import com.danishpinto.project1.portfolioapplication.entity.User;
import com.danishpinto.project1.portfolioapplication.exception.*;
import com.danishpinto.project1.portfolioapplication.repository.StockRepository;
import com.danishpinto.project1.portfolioapplication.repository.TradedStockRepository;
import com.danishpinto.project1.portfolioapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TradeService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    TradedStockRepository tradedStockRepository;

    public void makeTrade(TradeBean trade) {

        // sell -> if the final qty is 0, delete the stock entry from the list of TradedStock and update the User entity. Also delete the TradedStock from the database.
        // sell -> if the final qty is more than 0, update the stock entry from the list of TradedStock
        // buy -> update the buyCount, qty, buyPrice in the TradedStock

        if(isNotValidTradeRequestType(trade.getTypeOfTransaction())) {
            throw new InvalidTradeRequestException();
        }

        String stockId = trade.getStockId();
        Optional <Stock> stock = stockRepository.findById(stockId);
        if(stock.isEmpty()) {
            throw new StockNotFoundException("id: " + stockId);
        }

        int userId = trade.getUserId();
        Optional<User> possibleUser = userRepository.findById(userId);

        if(isNewUserAndWantsToSell(possibleUser, trade.getTypeOfTransaction())) {
            throw new NewUserNoHoldingException();
        }

        User user = possibleUser.orElseGet(() -> new User(trade.getUserId()));
        userRepository.save(user);
        List<TradedStock> tradedStockList = user.getTradedStocks();

        if(isNotPossibleToSell(tradedStockList, trade)) {
            throw new StockNotHeldException("StockId: " + trade.getStockId());
        }

        if(trade.getTypeOfTransaction().equalsIgnoreCase("buy")) {
            buyStock(trade, user);
        }

        else {
            sellStock(trade, user);
        }
    }

    private void buyStock(TradeBean trade, User user) {
        List <TradedStock> tradedStockList = user.getTradedStocks();
        int index = -1;
        for(int i = 0; i < tradedStockList.size(); i++) {
            if(Objects.equals(tradedStockList.get(i).getStockId(), trade.getStockId())) {
                index = i;
                break;
            }
        }

        Optional<Stock> StockToBuy = stockRepository.findById(trade.getStockId());

        if(index == -1) {
            // create a new trade
            TradedStock newTradedStock = new TradedStock(trade.getStockId(), StockToBuy.get().getClosePrice() * trade.getQuantity().doubleValue(), trade.getQuantity(), user);
            tradedStockRepository.save(newTradedStock);
            tradedStockList.add(newTradedStock);
            userRepository.save(user);
        }

        else {
            // stock already exists, just update the totalBuyPrice
            Double currentTotalBuyPrice = tradedStockList.get(index).getTotalBuyPrice();
            Long currentQuantity = tradedStockList.get(index).getQuantity();

            tradedStockList.get(index).setTotalBuyPrice(currentTotalBuyPrice + (StockToBuy.get().getClosePrice() * trade.getQuantity().doubleValue()));
            tradedStockList.get(index).setQuantity(currentQuantity + trade.getQuantity());

            Optional<TradedStock> currentTradedStock = tradedStockRepository.findById(tradedStockList.get(index).getDummyId());
            currentTradedStock.get().setTotalBuyPrice(currentTotalBuyPrice + (StockToBuy.get().getClosePrice() * trade.getQuantity().doubleValue()));
            currentTradedStock.get().setQuantity(currentQuantity + trade.getQuantity());

            tradedStockRepository.save(currentTradedStock.get());
            user.setTradedStocks(tradedStockList);
            userRepository.save(user);
        }
    }

    private void sellStock(TradeBean trade, User user) {

        int index = -1;
        List<TradedStock> tradedStockList = user.getTradedStocks();

        for(int i = 0; i < tradedStockList.size(); i++) {
            if(Objects.equals(tradedStockList.get(i).getStockId(), trade.getStockId())) {
                index = i;
                break;
            }
        }

        Long currentQuantity = tradedStockList.get(index).getQuantity();
        if(trade.getQuantity() > currentQuantity) {
            throw new InsufficientSharesToSellException("Stockid: " + trade.getStockId());
        }

        long finalQuantity = currentQuantity - trade.getQuantity();
        Optional<Stock> StockToSell = stockRepository.findById(trade.getStockId());

        if(finalQuantity == 0) {
            // delete entry from TradedStock entity
            tradedStockRepository.deleteById(tradedStockList.get(index).getDummyId());

            // delete entry from TradedStock list of user
            tradedStockList.remove(index);
            user.setTradedStocks(tradedStockList);
            userRepository.save(user);
        }

        else {
            Double currentBuyPrice = tradedStockList.get(index).getTotalBuyPrice();
            Double currentStockSellingPrice = StockToSell.get().getClosePrice();

            tradedStockList.get(index).setQuantity(finalQuantity);
            tradedStockList.get(index).setTotalBuyPrice(currentBuyPrice - (currentStockSellingPrice * trade.getQuantity().doubleValue()));
            user.setTradedStocks(tradedStockList);
            userRepository.save(user);

            Optional<TradedStock> tradedStock = tradedStockRepository.findById(tradedStockList.get(index).getDummyId());
            tradedStock.get().setQuantity(finalQuantity);
            tradedStock.get().setTotalBuyPrice(currentBuyPrice - (currentStockSellingPrice * trade.getQuantity().doubleValue()));
            tradedStockRepository.save(tradedStock.get());
        }
    }

    private boolean isNewUserAndWantsToSell(Optional<User> possibleUser, String typeOfTransaction) {
        return (typeOfTransaction.equalsIgnoreCase("sell") && possibleUser.isEmpty());
    }

    private boolean isNotPossibleToSell(List<TradedStock> tradedStockList, TradeBean tradeBean) {

        boolean isNotFound = true;

        for(TradedStock tradedStock: tradedStockList) {
            if(Objects.equals(tradedStock.getStockId(), tradeBean.getStockId())) {
                isNotFound = false;
                break;
            }
        }

        return (isNotFound && tradeBean.getTypeOfTransaction().equalsIgnoreCase("sell"));
    }

    private boolean isNotValidTradeRequestType(String typeOfTransaction) {
        return (!typeOfTransaction.equalsIgnoreCase("buy") && !typeOfTransaction.equalsIgnoreCase("sell"));
    }
}