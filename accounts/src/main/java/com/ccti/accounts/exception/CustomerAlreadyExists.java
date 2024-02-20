package com.ccti.accounts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomerAlreadyExists extends  RuntimeException{

    public CustomerAlreadyExists(String message){
        super(message);
    }
}
