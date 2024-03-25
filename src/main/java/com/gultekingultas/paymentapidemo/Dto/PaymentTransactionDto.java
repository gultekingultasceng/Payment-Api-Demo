package com.gultekingultas.paymentapidemo.Dto;

import com.gultekingultas.paymentapidemo.Entity.PaymentTransaction;
import com.gultekingultas.paymentapidemo.Enum.PaymentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentTransactionDto {
    private double amount;
    private PaymentType paymentType;
    private Long orderId;
    private boolean paymentStatus;
    private String cardNumber;

    public PaymentTransactionDto(PaymentTransaction paymentTransaction)
    {
        this.amount = paymentTransaction.getAmount();
        this.paymentType = PaymentType.valueOf(paymentTransaction.getPaymentType());
        this.orderId = paymentTransaction.getOrderId();
        this.paymentStatus = paymentTransaction.isOrderStatus();
        this.cardNumber = paymentTransaction.getCardNumber();
    }
}
