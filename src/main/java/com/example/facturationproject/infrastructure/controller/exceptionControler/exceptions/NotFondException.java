package com.example.facturationproject.infrastructure.controller.exceptionControler.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFondException extends RuntimeException {
    public NotFondException(String message){
        super(message);
    }

}
