package com.gultekingultas.paymentapidemo.Service;

import com.gultekingultas.paymentapidemo.Dto.PaymentRequestDto;
import com.gultekingultas.paymentapidemo.Dto.PaymentResponseDto;
import com.gultekingultas.paymentapidemo.Exception.PaymentException;
import com.gultekingultas.paymentapidemo.Kafka.PaymentEventProducer;
import com.gultekingultas.paymentapidemo.Service.Base.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements IPaymentService {

    final
    ApplicationContext context;
    final
    PaymentEventProducer paymentEventProducer;

    public PaymentService(ApplicationContext context , PaymentEventProducer paymentEventProducer) {
        this.context = context;
        this.paymentEventProducer = paymentEventProducer;
    }

    public IPaymentService getRelatedPayment(String paymentMethod)
    {
        return (IPaymentService) context.getBean(paymentMethod);
    }

    @Override
    public PaymentResponseDto processPayment(PaymentRequestDto paymentRequestDto) throws PaymentException {
        String paymentType = paymentRequestDto.getPaymentType().toString();
        try{
            PaymentResponseDto responseDto = getRelatedPayment(paymentType).processPayment(paymentRequestDto);
            if (!responseDto.getPaymentStatus())
                paymentEventProducer.sendPaymentEvent(paymentRequestDto);
            return responseDto ;
        }catch (Exception e){
            throw new PaymentException(paymentType);
        }
    }
}
