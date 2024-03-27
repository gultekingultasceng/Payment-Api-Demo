package com.gultekingultas.paymentapidemo.RabbitMQ;

import com.gultekingultas.paymentapidemo.Dto.PaymentRequestDto;
import com.gultekingultas.paymentapidemo.Kafka.PaymentEventProducerKafka;
import com.rabbitmq.client.AMQP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventProducerRabbitmq {

    private final Logger logger = LoggerFactory.getLogger(PaymentEventProducerRabbitmq.class);


    @Value("${spring.rabbitmq.template.routing-key}")
    String routingKey;

    private final AmqpTemplate rabbitTemplate;
    private  final DirectExchange exchange;

    public PaymentEventProducerRabbitmq(AmqpTemplate rabbitTemplate, DirectExchange exchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
    }

    public void sendMessage(PaymentRequestDto paymentRequestDto) {
        rabbitTemplate.convertAndSend(exchange.getName(), routingKey, paymentRequestDto);
        logger.info("Sent payment event: {}", paymentRequestDto);
    }
}
