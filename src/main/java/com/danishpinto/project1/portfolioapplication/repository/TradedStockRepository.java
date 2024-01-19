package com.danishpinto.project1.portfolioapplication.repository;

import com.danishpinto.project1.portfolioapplication.entity.TradedStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradedStockRepository extends JpaRepository<TradedStock, Integer> {

}
