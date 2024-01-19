package com.danishpinto.project1.portfolioapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidTradeRequestException extends RuntimeException {
    public InvalidTradeRequestException() {
        super("Transaction must be either of buy or sell");
    }
}
