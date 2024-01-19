package com.danishpinto.project1.portfolioapplication.repository;

import com.danishpinto.project1.portfolioapplication.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, String> {

}
