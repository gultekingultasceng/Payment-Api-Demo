package com.gultekingultas.paymentapidemo.Service;

import com.gultekingultas.paymentapidemo.Dto.PaymentRequestDto;
import com.gultekingultas.paymentapidemo.Dto.PaymentResponseDto;
import com.gultekingultas.paymentapidemo.Service.Base.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public PaymentResponseDto processPayment(PaymentRequestDto paymentRequestDto) throws Exception {
        try{
            var paymentType = paymentRequestDto.getPaymentType().toString();
            return getRelatedPayment(paymentType).processPayment(paymentRequestDto);
        }catch (Exception e){
            throw new Exception();
        }

    }
}
