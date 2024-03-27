package com.gultekingultas.paymentapidemo.Controller;
import com.gultekingultas.paymentapidemo.Dto.PaymentRequestDto;
import com.gultekingultas.paymentapidemo.Exception.PaymentException;
import com.gultekingultas.paymentapidemo.Dto.PaymentResponseDto;
import com.gultekingultas.paymentapidemo.Service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping("/pay")
    public ResponseEntity<PaymentResponseDto> makePayment(@Valid @RequestBody PaymentRequestDto paymentRequestDto) throws PaymentException {
        PaymentResponseDto paymentResponseDto = paymentService.processPayment(paymentRequestDto);
            return new ResponseEntity<>(paymentResponseDto , HttpStatus.OK);
    }
}
