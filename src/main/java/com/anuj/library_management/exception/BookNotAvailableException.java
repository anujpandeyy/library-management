package com.anuj.library_management.exception;

import java.util.UUID;

public class BookNotAvailableException extends RuntimeException{
    public BookNotAvailableException(UUID id){
        super("Book not available exception with ID: "+id);
    }
}
