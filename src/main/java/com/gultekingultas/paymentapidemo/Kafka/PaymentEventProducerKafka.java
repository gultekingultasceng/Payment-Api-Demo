package com.gultekingultas.paymentapidemo.Kafka;

import com.gultekingultas.paymentapidemo.Dto.PaymentRequestDto;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentEventProducerKafka {
    private static final String TOPIC = "payment-events";
    private final Logger logger = LoggerFactory.getLogger(PaymentEventProducerKafka.class);
    private final KafkaTemplate<String, PaymentRequestDto> kafkaTemplate;

    public PaymentEventProducerKafka(KafkaTemplate<String, PaymentRequestDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPaymentEvent(PaymentRequestDto paymentRequestDto) {
        ProducerRecord<String, PaymentRequestDto> record = new ProducerRecord<>(TOPIC, paymentRequestDto);
        kafkaTemplate.send(record);
        logger.info("Sent payment event: {}", paymentRequestDto);
    }


}
