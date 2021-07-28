package com.example.companyservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandling {


    public ResponseEntity<String>handleEmptyValue(EmptyInputException emptyException){
        return new ResponseEntity<>(emptyException.getErrorMessage(),HttpStatus.BAD_REQUEST);
    }
}
