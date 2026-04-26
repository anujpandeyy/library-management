package com.anuj.library_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GloballyExceptionHandler {
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleBookNotFound(BookNotFoundException ex){
        Map<String,String> error = new HashMap<>();
        error.put("error","Book Unavailable");
        error.put("message",ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookNotAvailableException.class)

    public ResponseEntity<Map<String,String>> bookNotAvailableExceptionHandler(BookNotAvailableException ex){
        Map<String,String> error = new HashMap<>();
        error.put("error","Book Not Available");
        error.put("message",ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateLoanException.class)

    public ResponseEntity<Map<String,String>> duplicateLoanExceptionHandler(DuplicateLoanException ex){
        Map<String,String> error = new HashMap<>();
        error.put("error","Duplicate Loan Exception");
        error.put("message",ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MemberNotFoundException.class)

    public ResponseEntity<Map<String,String>> globalExceptionHandler(MemberNotFoundException ex){
        Map<String,String> error = new HashMap<>();
        error.put("error","Member Not Found Exception");
        error.put("message",ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
