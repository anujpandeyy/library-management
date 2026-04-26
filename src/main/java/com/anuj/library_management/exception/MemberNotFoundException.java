package com.anuj.library_management.exception;

import java.util.UUID;

public class MemberNotFoundException extends RuntimeException{
    public MemberNotFoundException(UUID id){
        super("Member Not Found Exception: "+id);
    }
}
