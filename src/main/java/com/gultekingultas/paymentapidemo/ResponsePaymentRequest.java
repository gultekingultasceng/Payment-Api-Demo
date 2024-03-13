package com.gultekingultas.paymentapidemo;

import com.gultekingultas.paymentapidemo.Enum.PaymentType;
import com.gultekingultas.paymentapidemo.Utility.CardUtil;

public class ResponsePaymentRequest {
    private double amount;
    private PaymentType paymentType;
    private Long orderId;
    private String paymentDetails;
    private String cardNumber;
    private boolean paymentStatus;


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
        this.cardNumber = CardUtil.maskTheCardNumber(cardNumber);
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
