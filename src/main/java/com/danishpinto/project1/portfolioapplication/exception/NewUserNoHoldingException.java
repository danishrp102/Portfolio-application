package com.danishpinto.project1.portfolioapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class NewUserNoHoldingException extends RuntimeException{
    public NewUserNoHoldingException() {
        super("New user found. Cannot sell as a new user");
    }
}
