package com.FlexCrewBank.BankingApi.Exception;

import org.springframework.http.HttpStatus;

public class MessageException extends RuntimeException {
    private String message;
    private HttpStatus status;

    public MessageException(HttpStatus status, String message){
        super(message);
        this.status =status;
    }
}
