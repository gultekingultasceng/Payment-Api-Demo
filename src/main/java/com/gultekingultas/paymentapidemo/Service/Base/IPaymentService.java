package com.gultekingultas.paymentapidemo.Service.Base;

import com.gultekingultas.paymentapidemo.Dto.PaymentRequestDto;
import com.gultekingultas.paymentapidemo.Dto.PaymentResponseDto;


public interface IPaymentService {
    PaymentResponseDto processPayment(PaymentRequestDto paymentRequestDto);
}
