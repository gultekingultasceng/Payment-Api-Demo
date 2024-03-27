package com.gultekingultas.paymentapidemo.Service;

import com.gultekingultas.paymentapidemo.Dto.PaymentRequestDto;
import com.gultekingultas.paymentapidemo.Dto.PaymentResponseDto;
import com.gultekingultas.paymentapidemo.Exception.PaymentException;
import com.gultekingultas.paymentapidemo.Kafka.PaymentEventProducerKafka;
import com.gultekingultas.paymentapidemo.RabbitMQ.PaymentEventProducerRabbitmq;
import com.gultekingultas.paymentapidemo.Service.Base.IPaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements IPaymentService {

    final
    ApplicationContext context;
    final
    PaymentEventProducerKafka paymentEventProducerKafka;
    final
    PaymentEventProducerRabbitmq paymentEventProducerRabbitmq;

    public PaymentService(ApplicationContext context , PaymentEventProducerKafka paymentEventProducerKafka, PaymentEventProducerRabbitmq paymentEventProducerRabbitmq) {
        this.context = context;
        this.paymentEventProducerKafka = paymentEventProducerKafka;
        this.paymentEventProducerRabbitmq = paymentEventProducerRabbitmq;
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
            {
                 paymentEventProducerKafka.sendPaymentEvent(paymentRequestDto);
                // paymentEventProducerRabbitmq.sendMessage(paymentRequestDto);
            }
            return responseDto ;
        }catch (Exception e){
            throw new PaymentException(paymentType);
        }
    }
}
