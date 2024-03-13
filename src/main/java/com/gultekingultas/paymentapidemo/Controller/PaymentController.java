package com.gultekingultas.paymentapidemo.Controller;

import com.gultekingultas.paymentapidemo.Dto.PaymentRequest;
import com.gultekingultas.paymentapidemo.ResponsePaymentRequest;
import com.gultekingultas.paymentapidemo.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {


    @Autowired
    private PaymentService paymentService;

    @PostMapping("/makepayment")
    public ResponseEntity<ResponsePaymentRequest> makePayment(@RequestBody PaymentRequest paymentRequest)
    {
        try{
            return new ResponseEntity<>(paymentService.processPayment(paymentRequest) , HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
