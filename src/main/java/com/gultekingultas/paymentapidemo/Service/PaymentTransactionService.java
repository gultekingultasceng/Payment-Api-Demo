package com.gultekingultas.paymentapidemo.Service;

import com.gultekingultas.paymentapidemo.Dto.PaymentRequestDto;
import com.gultekingultas.paymentapidemo.Entity.PaymentTransaction;
import com.gultekingultas.paymentapidemo.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentTransactionService {

    @Autowired
    PaymentRepository paymentRepository;
    public void createPaymentTransactionFromPaymentRequest(PaymentRequestDto paymentRequestDto , boolean isPaymentStatusOK)
    {
        PaymentTransaction paymentTransaction = new PaymentTransaction();
        paymentTransaction.setPaymentType(paymentRequestDto.getPaymentType().toString());
        paymentTransaction.setAmount(paymentRequestDto.getAmount());
        paymentTransaction.setOrderId(paymentRequestDto.getOrderId());
        paymentTransaction.setCardNumber(paymentRequestDto.getCardNumber());
        paymentTransaction.setOrderStatus(isPaymentStatusOK);
        //
        paymentRepository.save(paymentTransaction);
    }
}
