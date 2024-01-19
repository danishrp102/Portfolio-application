package com.danishpinto.project1.portfolioapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class InsufficientSharesToSellException extends RuntimeException {
    public InsufficientSharesToSellException(String message) {
        super("Cannot sell more shares than current holdings: " + message);
    }
}
