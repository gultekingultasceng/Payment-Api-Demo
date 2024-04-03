package com.gultekingultas.paymentapidemo.Service;

import com.gultekingultas.paymentapidemo.Dto.PaymentRequestDto;
import com.gultekingultas.paymentapidemo.Dto.PaymentResponseDto;
import com.gultekingultas.paymentapidemo.Enum.PaymentType;
import com.gultekingultas.paymentapidemo.Kafka.PaymentEventProducerKafka;
import com.gultekingultas.paymentapidemo.RabbitMQ.PaymentEventProducerRabbitmq;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {

    @InjectMocks
    PaymentService paymentService;
    @Mock
    ApplicationContext context;
    @Mock
    PaymentEventProducerKafka paymentEventProducerKafka;
    @Mock
    PaymentEventProducerRabbitmq paymentEventProducerRabbitmq;


    @Before
    public void setUp() {

    }
    @After
    public void resetMocks()
    {
        Mockito.reset();
    }
    @Test
    public void  processPaymentTest_Success()
    {

    }



}
