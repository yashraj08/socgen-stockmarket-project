package com.example.exchangeservice.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

@EqualsAndHashCode(callSuper = true)
@Data
@Component
public class EmptyInputException extends RuntimeException{
    private static final long serialVersionUID=1L;
    private String errorCode;
    private String errorMessage;
    public EmptyInputException(){}
    public EmptyInputException(String errorCode, String errorMessage){
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }
}
