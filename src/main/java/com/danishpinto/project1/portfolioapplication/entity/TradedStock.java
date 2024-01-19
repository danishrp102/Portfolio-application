package com.danishpinto.project1.portfolioapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class TradedStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dummyId;

    @Column
    private String stockId;
    @Column
    private Double totalBuyPrice;
    @Column
    private Long quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public TradedStock() {

    }

    public TradedStock(String stockId, Double totalBuyPrice, Long quantity, User user) {
        this.stockId = stockId;
        this.totalBuyPrice = totalBuyPrice;
        this.quantity = quantity;
        this.user = user;
    }

//    public TradedStock(Integer dummyId, String stockId, Double totalBuyPrice, Long quantity, User user) {
//        this.dummyId = dummyId;
//        this.stockId = stockId;
//        this.totalBuyPrice = totalBuyPrice;
//        this.quantity = quantity;
//        this.user = user;
//    }

    public Integer getDummyId() {
        return dummyId;
    }

    public void setDummyId(Integer dummyId) {
        this.dummyId = dummyId;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public Double getTotalBuyPrice() {
        return totalBuyPrice;
    }

    public void setTotalBuyPrice(Double totalBuyPrice) {
        this.totalBuyPrice = totalBuyPrice;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "TradedStock{" +
                "dummyId=" + dummyId +
                ", stockId='" + stockId + '\'' +
                ", totalBuyPrice=" + totalBuyPrice +
                ", quantity=" + quantity +
                ", user=" + user +
                '}';
    }
}
