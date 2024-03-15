package com.gultekingultas.paymentapidemo.Handler;

import com.gultekingultas.paymentapidemo.Exception.InvalidCardNumberException;
import com.gultekingultas.paymentapidemo.Exception.PaymentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(InvalidCardNumberException.class)
    public ResponseEntity<String> handleInvalidCardNumberException(InvalidCardNumberException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(PaymentException.class)
    public ResponseEntity<String> handlePaymentException(PaymentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
