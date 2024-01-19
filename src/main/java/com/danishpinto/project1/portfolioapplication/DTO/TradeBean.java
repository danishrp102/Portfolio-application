package com.danishpinto.project1.portfolioapplication.DTO;

public class TradeBean {
    private Integer userId;
    private String stockId;
    private String typeOfTransaction;
    private Long quantity;

    public TradeBean() {

    }

    public TradeBean(Integer userId, String stockId, String typeOfTransaction, Long quantity) {
        this.userId = userId;
        this.stockId = stockId;
        this.typeOfTransaction = typeOfTransaction;
        this.quantity = quantity;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public void setTypeOfTransaction(String typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "TradeBean{" +
                "userId=" + userId +
                ", stockId='" + stockId + '\'' +
                ", typeOfTransaction='" + typeOfTransaction + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
