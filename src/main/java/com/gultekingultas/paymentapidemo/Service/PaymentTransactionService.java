package com.gultekingultas.paymentapidemo.Service;

import com.gultekingultas.paymentapidemo.Dto.PaymentRequest;
import com.gultekingultas.paymentapidemo.Entity.PaymentTransaction;
import com.gultekingultas.paymentapidemo.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentTransactionService {

    @Autowired
    PaymentRepository paymentRepository;
    public PaymentTransaction createPaymentTransactionFromPaymentRequest(PaymentRequest paymentRequest)
    {
        PaymentTransaction paymentTransaction = new PaymentTransaction();
        paymentTransaction.setPaymentDetails(paymentRequest.getPaymentDetails());
        paymentTransaction.setPaymentType(paymentRequest.getPaymentType().toString());
        paymentTransaction.setAmount(paymentRequest.getAmount());
        paymentTransaction.setOrderId(paymentRequest.getOrderId());
        paymentTransaction.setCardNumber(paymentRequest.getCardNumber());
        //
        return paymentTransaction;
    }
}
