package com.gultekingultas.paymentapidemo.Exception;

public class PaymentException extends Exception{


    public PaymentException(String paymentType)
    {
        super(paymentType+" payment exception");
    }
}
