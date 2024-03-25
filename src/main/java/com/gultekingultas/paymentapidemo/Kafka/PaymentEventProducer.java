package com.gultekingultas.paymentapidemo.Kafka;

import com.gultekingultas.paymentapidemo.Dto.PaymentRequestDto;
import com.gultekingultas.paymentapidemo.Dto.PaymentTransactionDto;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentEventProducer {
    private static final String TOPIC = "payment-events";
    private final Logger logger = LoggerFactory.getLogger(PaymentEventProducer.class);
    private final KafkaTemplate<String, PaymentRequestDto> kafkaTemplate;

    public PaymentEventProducer(KafkaTemplate<String, PaymentRequestDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPaymentEvent(PaymentRequestDto paymentRequestDto) {
        ProducerRecord<String, PaymentRequestDto> record = new ProducerRecord<>(TOPIC, paymentRequestDto);
        kafkaTemplate.send(record);
        logger.info("Sent payment event: {}", paymentRequestDto);
    }


}
