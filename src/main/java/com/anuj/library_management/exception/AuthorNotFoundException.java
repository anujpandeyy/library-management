package com.anuj.library_management.exception;

import java.util.UUID;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(UUID uuid){
        super("Author not found with ID: "+uuid);
    }
}
