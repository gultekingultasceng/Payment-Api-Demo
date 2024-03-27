package com.gultekingultas.paymentapidemo.Kafka;

import com.gultekingultas.paymentapidemo.Dto.PaymentRequestDto;
import com.gultekingultas.paymentapidemo.Exception.PaymentException;
import com.gultekingultas.paymentapidemo.Service.PaymentService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventConsumerKafka {

    private final Logger logger = LoggerFactory.getLogger(PaymentEventProducerKafka.class);

    final
    PaymentService paymentService;

    public PaymentEventConsumerKafka(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @KafkaListener(topics = "payment-events", groupId = "payment-group", concurrency = "1")
    public void consumePaymentEvent(ConsumerRecord<String, PaymentRequestDto> record) throws PaymentException {
        logger.info("Received payment event: {}", record.value());
        paymentService.processPayment(record.value());
    }

}
