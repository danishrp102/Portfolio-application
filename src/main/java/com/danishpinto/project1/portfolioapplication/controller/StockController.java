package com.danishpinto.project1.portfolioapplication.controller;

import com.danishpinto.project1.portfolioapplication.entity.Stock;
import com.danishpinto.project1.portfolioapplication.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping(value = "/upload", consumes = {"multipart/form-data"})
    public ResponseEntity<Integer> uploadStocks(
            @RequestPart("file") MultipartFile file
    ) throws IOException {
        return ResponseEntity.ok(stockService.uploadStocks(file));
    }

    @GetMapping(path = "/{stockId}")
    public Stock getStocks(@PathVariable String stockId) {
        return stockService.retreiveStock(stockId);
    }
}