package com.danishpinto.project1.portfolioapplication.DTO;

public class HoldingsDTO {
    private String stockName;
    private String stockId;
    private Long quantity;
    private Double buyPrice;
    private Double currentPrice;
    private Double gainOrLoss;

    public HoldingsDTO(String stockName, String stockId, Long quantity, Double buyPrice, Double currentPrice, Double gainOrLoss) {
        this.stockName = stockName;
        this.stockId = stockId;
        this.quantity = quantity;
        this.buyPrice = buyPrice;
        this.currentPrice = currentPrice;
        this.gainOrLoss = gainOrLoss;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Double getGainOrLoss() {
        return gainOrLoss;
    }

    public void setGainOrLoss(Double gainOrLoss) {
        this.gainOrLoss = gainOrLoss;
    }

    @Override
    public String toString() {
        return "HoldingsBean{" +
                "stockName='" + stockName + '\'' +
                ", stockId='" + stockId + '\'' +
                ", quantity=" + quantity +
                ", buyPrice=" + buyPrice +
                ", currentPrice=" + currentPrice +
                ", gainOrLoss=" + gainOrLoss +
                '}';
    }
}
