package com.gultekingultas.paymentapidemo.Dto;

import com.gultekingultas.paymentapidemo.Enum.PaymentType;

import java.util.Random;

public class PaymentResponseDto {
    private double amount;
    private PaymentType paymentType;
    private Long orderId;
    private boolean paymentStatus;

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
        Random random = new Random();
        return random.nextBoolean();
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }



    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
