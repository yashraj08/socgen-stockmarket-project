package com.example.authservice.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

@EqualsAndHashCode(callSuper = true)
@Data
@Component
public class UserNotFoundException extends  RuntimeException{
    private static final long serialVersionUID=1L;
    private String errorCode;
    private String errorMessage;

    public UserNotFoundException(){

    }
    public UserNotFoundException(String errorCode, String errorMessage) {
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }
}
