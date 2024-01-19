package com.danishpinto.project1.portfolioapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    private Integer id;
    @OneToMany(mappedBy = "user") // user is a User object created in the TradedStock entity
    @JsonIgnore
    List<TradedStock> tradedStocks;

    public User() {
        this.tradedStocks = new ArrayList<>();
    }

    public User(Integer id) {
        this.id = id;
        this.tradedStocks = new ArrayList<>();
    }

    public User(Integer id, List<TradedStock> tradedStocks) {
        this.id = id;
        this.tradedStocks = tradedStocks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<TradedStock> getTradedStocks() {
        return tradedStocks;
    }

    public void setTradedStocks(List<TradedStock> tradedStocks) {
        this.tradedStocks = tradedStocks;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", tradedStocks=" + tradedStocks +
                '}';
    }
}
