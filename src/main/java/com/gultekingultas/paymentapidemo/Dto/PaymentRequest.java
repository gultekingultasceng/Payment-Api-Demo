package com.gultekingultas.paymentapidemo.Dto;

import com.gultekingultas.paymentapidemo.Enum.PaymentType;

public class PaymentRequest {
    private double amount;
    private PaymentType paymentType;
    private Long orderId;
    private String paymentDetails;
    private String cardNumber;



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

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
