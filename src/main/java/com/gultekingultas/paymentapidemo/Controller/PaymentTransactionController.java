package com.gultekingultas.paymentapidemo.Controller;

import com.gultekingultas.paymentapidemo.Dto.PaymentTransactionDto;
import com.gultekingultas.paymentapidemo.Entity.PaymentTransaction;
import com.gultekingultas.paymentapidemo.Repository.PaymentRepository;
import com.gultekingultas.paymentapidemo.Service.PaymentTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/payments")
public class PaymentTransactionController {

    private final PaymentTransactionService paymentTransactionService;

    public PaymentTransactionController(PaymentTransactionService paymentTransactionService) {
        this.paymentTransactionService = paymentTransactionService;
    }

    @GetMapping("/getallpayments")
    public ResponseEntity<List<PaymentTransactionDto>> getAllPayments() throws Exception {
       return new ResponseEntity<>(paymentTransactionService.getAllPayments(), HttpStatus.OK);
    }
    @GetMapping("/getpaymentsbyorderid/{orderId}")
    public ResponseEntity<PaymentTransactionDto> getPaymentFromOrderId(@PathVariable Long orderId) throws Exception {
       return new ResponseEntity<>(paymentTransactionService.getPaymentFromOrderId(orderId) , HttpStatus.OK);
    }
}
