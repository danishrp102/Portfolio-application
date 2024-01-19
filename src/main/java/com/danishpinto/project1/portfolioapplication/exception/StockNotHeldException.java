package com.danishpinto.project1.portfolioapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class StockNotHeldException extends RuntimeException {
    public StockNotHeldException(String message) {
        super("The stock with " + message + " is not in your current holdings and hence cannot be sold");
    }
}
