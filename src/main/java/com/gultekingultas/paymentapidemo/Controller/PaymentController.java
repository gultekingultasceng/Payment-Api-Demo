package com.gultekingultas.paymentapidemo.Controller;

import com.gultekingultas.paymentapidemo.Annotations.ValidCardNumber;
import com.gultekingultas.paymentapidemo.Dto.PaymentRequestDto;
import com.gultekingultas.paymentapidemo.Entity.PaymentTransaction;
import com.gultekingultas.paymentapidemo.Repository.PaymentRepository;
import com.gultekingultas.paymentapidemo.Dto.PaymentResponseDto;
import com.gultekingultas.paymentapidemo.Service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @PostMapping("/makepayments")
    public ResponseEntity<PaymentResponseDto> makePayment(@Valid @RequestBody PaymentRequestDto paymentRequestDto) throws Exception {
        PaymentResponseDto paymentResponseDto = paymentService.processPayment(paymentRequestDto);
            return new ResponseEntity<>(paymentResponseDto , HttpStatus.OK);
    }






}
