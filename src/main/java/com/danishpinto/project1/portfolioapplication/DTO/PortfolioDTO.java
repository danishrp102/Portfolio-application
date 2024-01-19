package com.danishpinto.project1.portfolioapplication.DTO;

import java.util.List;

public class PortfolioDTO {
    private List<HoldingsDTO> holdingsList;
    private Double totalPortfolioHolding;
    private Double totalBuyPrice;
    private Double totalProfitOrLossPercentage;

    public PortfolioDTO(List<HoldingsDTO> holdingsList, Double totalPortfolioHolding, Double totalBuyPrice, Double totalProfitOrLossPercentage) {
        this.holdingsList = holdingsList;
        this.totalPortfolioHolding = totalPortfolioHolding;
        this.totalBuyPrice = totalBuyPrice;
        this.totalProfitOrLossPercentage = totalProfitOrLossPercentage;
    }

    public List<HoldingsDTO> getHoldingsList() {
        return holdingsList;
    }

    public void setHoldingsList(List<HoldingsDTO> holdingsList) {
        this.holdingsList = holdingsList;
    }

    public Double getTotalPortfolioHolding() {
        return totalPortfolioHolding;
    }

    public void setTotalPortfolioHolding(Double totalPortfolioHolding) {
        this.totalPortfolioHolding = totalPortfolioHolding;
    }

    public Double getTotalBuyPrice() {
        return totalBuyPrice;
    }

    public void setTotalBuyPrice(Double totalBuyPrice) {
        this.totalBuyPrice = totalBuyPrice;
    }

    public Double getTotalProfitOrLossPercentage() {
        return totalProfitOrLossPercentage;
    }

    public void setTotalProfitOrLossPercentage(Double totalProfitOrLossPercentage) {
        this.totalProfitOrLossPercentage = totalProfitOrLossPercentage;
    }

    @Override
    public String toString() {
        return "PortfolioBean{" +
                "holdingsList=" + holdingsList +
                ", totalPortfolioHolding=" + totalPortfolioHolding +
                ", totalBuyPrice=" + totalBuyPrice +
                ", totalProfitOrLossPercentage=" + totalProfitOrLossPercentage +
                '}';
    }
}
