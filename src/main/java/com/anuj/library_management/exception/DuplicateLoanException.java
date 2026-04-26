package com.anuj.library_management.exception;

import java.util.UUID;

public class DuplicateLoanException extends RuntimeException{
    public DuplicateLoanException(UUID id){
        super("Duplicate Loan Exception with ID: "+id);
    }
}
