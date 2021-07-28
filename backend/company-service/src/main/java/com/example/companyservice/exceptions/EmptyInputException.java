package com.example.companyservice.exceptions;

import lombok.Data;
import org.springframework.stereotype.Component;

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
