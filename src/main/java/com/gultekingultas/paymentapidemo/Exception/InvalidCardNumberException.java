package com.gultekingultas.paymentapidemo.Exception;

public class InvalidCardNumberException extends RuntimeException{
    public InvalidCardNumberException(String message)
    {
        super(message);
    }
}
