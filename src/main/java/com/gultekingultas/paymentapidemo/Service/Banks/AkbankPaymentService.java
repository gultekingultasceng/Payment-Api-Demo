package com.gultekingultas.paymentapidemo.Service.Banks;

import com.gultekingultas.paymentapidemo.Entity.PaymentTransaction;
import com.gultekingultas.paymentapidemo.Dto.PaymentRequest;
import com.gultekingultas.paymentapidemo.ResponsePaymentRequest;
import com.gultekingultas.paymentapidemo.Service.Base.IPaymentService;
import com.gultekingultas.paymentapidemo.Service.PaymentTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("Akbank")
public class AkbankPaymentService implements IPaymentService {

    @Autowired
    PaymentTransactionService paymentTransactionService;
    @Override
    public ResponsePaymentRequest processPayment(PaymentRequest paymentRequest) {
        paymentTransactionService.createPaymentTransactionFromPaymentRequest(paymentRequest);
        return null;
    }
}
