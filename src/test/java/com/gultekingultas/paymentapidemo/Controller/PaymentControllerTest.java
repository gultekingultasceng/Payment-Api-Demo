package com.gultekingultas.paymentapidemo.Controller;

import com.gultekingultas.paymentapidemo.Dto.PaymentRequestDto;
import com.gultekingultas.paymentapidemo.Dto.PaymentResponseDto;
import com.gultekingultas.paymentapidemo.Enum.PaymentType;
import com.gultekingultas.paymentapidemo.Exception.InvalidCardNumberException;
import com.gultekingultas.paymentapidemo.Exception.PaymentException;
import com.gultekingultas.paymentapidemo.Service.Base.IPaymentService;
import com.gultekingultas.paymentapidemo.Service.PaymentService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PaymentControllerTest {

    @InjectMocks
    private PaymentController paymentController;
    @Mock
    private PaymentService paymentService;
    @Test
    public void makePaymentTest_Success() throws Exception {
        PaymentRequestDto paymentRequestDto = new PaymentRequestDto();
        paymentRequestDto.setPaymentType(PaymentType.Akbank);
        paymentRequestDto.setAmount(255);
        paymentRequestDto.setCardNumber("4111111111111111");
        paymentRequestDto.setOrderId(1L);

        PaymentResponseDto paymentResponseDto = new PaymentResponseDto(255,PaymentType.Akbank,1L);

        when(paymentService.processPayment(paymentRequestDto)).thenReturn(paymentResponseDto);
        ResponseEntity<PaymentResponseDto> response = paymentController.makePayment(paymentRequestDto);
        assertEquals(HttpStatus.OK , response.getStatusCode());
        assertEquals(response.getBody() , paymentResponseDto);
    }
}
