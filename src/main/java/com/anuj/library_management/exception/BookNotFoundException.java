package com.anuj.library_management.exception;

import java.util.UUID;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(UUID id){
        super("Book not found with ID: "+id);
    }
}
