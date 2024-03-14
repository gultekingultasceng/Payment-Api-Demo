package com.gultekingultas.paymentapidemo.Dto;

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
}
