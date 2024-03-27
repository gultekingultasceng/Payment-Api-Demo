package com.gultekingultas.paymentapidemo.RabbitMQ;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    @Value("${spring.rabbitmq.template.exchange}")
    String exchange;

    @Value("${spring.rabbitmq.template.default-receive-queue}")
    String queueName;

    @Value("${spring.rabbitmq.template.routing-key}")
    String routingKey;



    @Bean
    DirectExchange exchange(){return new DirectExchange(exchange);}

    @Bean
    Queue paymentQueue(){return new Queue(queueName,false);}

    @Bean
    Binding binding(Queue paymentQueue , DirectExchange exchange)
    {
        return BindingBuilder.bind(paymentQueue).to(exchange).with(routingKey);
    }

    @Bean
    public MessageConverter jsonMessageConverter()
    {
        return new Jackson2JsonMessageConverter();
    }
}
