package com.gultekingultas.paymentapidemo.Dto;

import com.gultekingultas.paymentapidemo.Entity.PaymentTransaction;
import com.gultekingultas.paymentapidemo.Enum.PaymentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentTransactionDto {
    private String name;
    private String surname;
    private double amount;
    private PaymentType paymentType;
    private Long orderId;
    private boolean paymentStatus;
    private String cardNumber;

    public PaymentTransactionDto(PaymentTransaction paymentTransaction)
    {
        this.name = paymentTransaction.getName();
        this.surname = paymentTransaction.getSurname();
        this.amount = paymentTransaction.getAmount();
        this.paymentType = PaymentType.valueOf(paymentTransaction.getPaymentType());
        this.orderId = paymentTransaction.getOrderId();
        this.paymentStatus = paymentTransaction.isOrderStatus();
        this.cardNumber = paymentTransaction.getCardNumber();
    }
}
