package com.danishpinto.project1.portfolioapplication.service;

import com.opencsv.bean.CsvBindByName;

public class StockCsvRepresentation {

    @CsvBindByName(column = "ISIN")
    private String id;
    @CsvBindByName(column = "SYMBOL")
    private String name;
    @CsvBindByName(column = "OPEN")
    private Double openPrice;
    @CsvBindByName(column = "CLOSE")
    private Double closePrice;
    @CsvBindByName(column = "HIGH")
    private Double highPrice;
    @CsvBindByName(column = "LOW")
    private Double lowPrice;
    @CsvBindByName(column = "PREVCLOSE")
    private Double settlementPrice;

    public StockCsvRepresentation() {

    }

    public StockCsvRepresentation(String id, String name, Double openPrice, Double closePrice, Double highPrice, Double lowPrice, Double settlementPrice) {
        this.id = id;
        this.name = name;
        this.openPrice = openPrice;
        this.closePrice = closePrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.settlementPrice = settlementPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(Double openPrice) {
        this.openPrice = openPrice;
    }

    public Double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(Double closePrice) {
        this.closePrice = closePrice;
    }

    public Double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(Double highPrice) {
        this.highPrice = highPrice;
    }

    public Double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Double getSettlementPrice() {
        return settlementPrice;
    }

    public void setSettlementPrice(Double prevClose) {
        this.settlementPrice = prevClose;
    }

    @Override
    public String toString() {
        return "StockCsvRepresentation{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", openPrice=" + openPrice +
                ", closePrice=" + closePrice +
                ", highPrice=" + highPrice +
                ", lowPrice=" + lowPrice +
                ", settlementPrice=" + settlementPrice +
                '}';
    }
}