package com.gultekingultas.paymentapidemo.Dto;

import com.gultekingultas.paymentapidemo.Enum.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Setter
@Getter

public class PaymentResponseDto {
    private double amount;
    private PaymentType paymentType;
    private Long orderId;
    private boolean paymentStatus;
    Random randomPaymentStatus;
    public PaymentResponseDto(double amount, PaymentType paymentType, Long orderId) {
        this.amount = amount;
        this.paymentType = paymentType;
        this.orderId = orderId;
        this.paymentStatus = getRandomPaymentStatus();
    }
    public boolean getPaymentStatus()
    {
        return this.paymentStatus;
    }
    private boolean getRandomPaymentStatus()
    {
        randomPaymentStatus = new Random();
        return randomPaymentStatus.nextBoolean();
    }




}
