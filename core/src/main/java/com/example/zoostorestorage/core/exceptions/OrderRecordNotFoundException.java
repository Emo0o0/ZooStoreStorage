package com.example.zoostorestorage.core.exceptions;

public class OrderRecordNotFoundException extends RuntimeException{

    public OrderRecordNotFoundException(String message){
        super(message);
    }
}
