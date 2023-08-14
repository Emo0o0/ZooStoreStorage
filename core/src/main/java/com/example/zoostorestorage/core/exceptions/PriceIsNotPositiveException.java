package com.example.zoostorestorage.core.exceptions;

public class PriceIsNotPositiveException extends RuntimeException{
    public PriceIsNotPositiveException(String message){
        super(message);
    }
}
