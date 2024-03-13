package com.gultekingultas.paymentapidemo.Service.Base;

import com.gultekingultas.paymentapidemo.Dto.PaymentRequest;
import com.gultekingultas.paymentapidemo.ResponsePaymentRequest;


public interface IPaymentService {
    ResponsePaymentRequest processPayment(PaymentRequest paymentRequest);
}
