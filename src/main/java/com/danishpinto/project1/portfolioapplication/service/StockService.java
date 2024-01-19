package com.danishpinto.project1.portfolioapplication.service;

import com.danishpinto.project1.portfolioapplication.entity.Stock;
import com.danishpinto.project1.portfolioapplication.repository.StockRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Integer uploadStocks(MultipartFile file) throws IOException {
        Set<Stock> stocks = parseCsv(file);
        stockRepository.saveAll(stocks);
        return stocks.size();
    }

    private Set<Stock> parseCsv(MultipartFile file) throws IOException {

        try(Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            HeaderColumnNameMappingStrategy<StockCsvRepresentation> strategy =
                    new HeaderColumnNameMappingStrategy<>();
            strategy.setType(StockCsvRepresentation.class);
            CsvToBean<StockCsvRepresentation> csvToBean =
                    new CsvToBeanBuilder<StockCsvRepresentation>(reader)
                            .withMappingStrategy(strategy)
                            .withIgnoreEmptyLine(true)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();

            return csvToBean
                    .parse()
                    .stream()
                    .map(csvLine -> new Stock(csvLine.getId(), csvLine.getName(), csvLine.getOpenPrice(), csvLine.getHighPrice(), csvLine.getLowPrice(), csvLine.getClosePrice(), csvLine.getSettlementPrice()))
                    .collect(Collectors.toSet());
        }
    }

    public List<Stock> retrieveAllStocks() {
        return stockRepository.findAll();
    }
}
