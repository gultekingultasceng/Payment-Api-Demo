package com.gultekingultas.paymentapidemo.Entity;

import com.gultekingultas.paymentapidemo.Utility.CardUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PaymentTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double amount;
    private String paymentType;
    private Long orderId;
    private String paymentDetails;
    private String cardNumber;
    private boolean orderStatus;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double _amount) {
        this.amount = _amount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String _paymentType) {
        this.paymentType = _paymentType;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long _orderId) {
        this.orderId = _orderId;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String _paymentDetails) {
        this.paymentDetails = _paymentDetails;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = CardUtil.maskTheCardNumber(cardNumber);
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }
}
