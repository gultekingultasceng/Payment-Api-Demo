package com.gultekingultas.paymentapidemo.Dto;

import com.gultekingultas.paymentapidemo.Enum.PaymentType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentRequestDto {

    private double amount;
    private PaymentType paymentType;
    private Long orderId;
    private String cardNumber;

}
