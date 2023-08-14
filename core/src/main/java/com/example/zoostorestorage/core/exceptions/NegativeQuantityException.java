package com.example.zoostorestorage.core.exceptions;

public class NegativeQuantityException extends RuntimeException{
    public NegativeQuantityException(String message){
        super(message);
    }
}
