package com.example.authservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandling {
    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<String> handleIncorrectPassword(IncorrectPasswordException incorrectPasswordException){
        return new ResponseEntity<>(incorrectPasswordException.getErrorMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException userNotFoundException){
        return new ResponseEntity<>(userNotFoundException.getErrorMessage(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<String>handleEmptyValue(EmptyInputException emptyInputException){
        return new ResponseEntity<>(emptyInputException.getErrorMessage(),HttpStatus.BAD_REQUEST);
    }
}
