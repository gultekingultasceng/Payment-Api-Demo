package com.gultekingultas.paymentapidemo.Controller;

import com.gultekingultas.paymentapidemo.Dto.PaymentTransactionDto;
import com.gultekingultas.paymentapidemo.Entity.PaymentTransaction;
import com.gultekingultas.paymentapidemo.Enum.PaymentType;
import com.gultekingultas.paymentapidemo.Repository.PaymentRepository;
import com.gultekingultas.paymentapidemo.Service.PaymentTransactionService;
import jakarta.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PaymentTransactionControllerTest {

    @InjectMocks
    PaymentTransactionController paymentTransactionController;
    @Mock
    PaymentTransactionService paymentTransactionService;





    @Test
    public void getAllPaymentsTest_Success() throws Exception {

        // First add paymenttransaction entities to database manually
        PaymentTransaction paymentTransaction = new PaymentTransaction();
        paymentTransaction.setOrderStatus(true);
        paymentTransaction.setPaymentDetails("");
        paymentTransaction.setAmount(255);
        paymentTransaction.setCardNumber("**** **** **** 1111");
        paymentTransaction.setOrderId(2L);
        paymentTransaction.setPaymentType(PaymentType.Akbank.toString());

        PaymentTransactionDto paymentTransactionDto = new PaymentTransactionDto(paymentTransaction);
        List<PaymentTransactionDto> payments = new ArrayList<>();
        payments.add(paymentTransactionDto);
        Mockito.when(paymentTransactionService.getAllPayments()).thenReturn(payments);
        ResponseEntity<List<PaymentTransactionDto>> response = paymentTransactionController.getAllPayments();
        assertEquals(response.getStatusCode() , HttpStatus.OK);
        assertEquals(Objects.requireNonNull(response.getBody()).size() , payments.size());
        for (int i = 0 ; i < response.getBody().size(); i ++)
        {
            assertEquals(response.getBody().get(i) , payments.get(i));
        }


    }

    @Test
    public void getPaymentByOrderIdTest_Success() throws Exception {
        // First add paymenttransaction entities to database manually
        PaymentTransaction paymentTransaction = new PaymentTransaction();
        paymentTransaction.setOrderStatus(true);
        paymentTransaction.setPaymentDetails("");
        paymentTransaction.setAmount(255);
        paymentTransaction.setCardNumber("**** **** **** 1111");
        paymentTransaction.setOrderId(2L);
        paymentTransaction.setPaymentType(PaymentType.Akbank.toString());

        PaymentTransactionDto paymentTransactionDto = new PaymentTransactionDto(paymentTransaction);
        Mockito.when(paymentTransactionService.getPaymentFromOrderId(2L)).thenReturn(paymentTransactionDto);
        ResponseEntity<PaymentTransactionDto> response = paymentTransactionController.getPaymentFromOrderId(2L);
        assertEquals(response.getBody() , paymentTransactionDto);
    }
}
