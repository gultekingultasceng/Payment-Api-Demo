package com.gultekingultas.paymentapidemo.Service;

import com.gultekingultas.paymentapidemo.Dto.PaymentRequest;
import com.gultekingultas.paymentapidemo.ResponsePaymentRequest;
import com.gultekingultas.paymentapidemo.Service.Base.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    ApplicationContext context;
    public IPaymentService getRelatedPayment(String paymentMethod)
    {
        return (IPaymentService) context.getBean(paymentMethod);
    }

    @Override
    public ResponsePaymentRequest processPayment(PaymentRequest paymentRequest) {
        return getRelatedPayment(paymentRequest.getPaymentType().toString()).processPayment(paymentRequest);
    }
}
