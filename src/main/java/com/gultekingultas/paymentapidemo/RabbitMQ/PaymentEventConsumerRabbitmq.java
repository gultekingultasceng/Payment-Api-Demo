package com.gultekingultas.paymentapidemo.RabbitMQ;

import com.gultekingultas.paymentapidemo.Dto.PaymentRequestDto;
import com.gultekingultas.paymentapidemo.Exception.PaymentException;
import com.gultekingultas.paymentapidemo.Service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventConsumerRabbitmq {

    private final Logger logger = LoggerFactory.getLogger(PaymentEventConsumerRabbitmq.class);

    final
    PaymentService paymentService;

    public PaymentEventConsumerRabbitmq(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @RabbitListener(queues = "paymentQueue")
    public void receiveMessage(PaymentRequestDto paymentRequestDto) throws PaymentException {
        logger.info("Received payment event: {}", paymentRequestDto);
        paymentService.processPayment(paymentRequestDto);
    }
}
