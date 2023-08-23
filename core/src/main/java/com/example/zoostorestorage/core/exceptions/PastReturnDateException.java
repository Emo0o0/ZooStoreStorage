package com.example.zoostorestorage.core.exceptions;

public class PastReturnDateException extends RuntimeException {

    public PastReturnDateException(String message){
        super(message);
    }
}
