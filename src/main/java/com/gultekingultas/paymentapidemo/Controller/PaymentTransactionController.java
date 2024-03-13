package com.gultekingultas.paymentapidemo.Controller;

import com.gultekingultas.paymentapidemo.Entity.PaymentTransaction;
import com.gultekingultas.paymentapidemo.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PaymentTransactionController {

    @Autowired
    private PaymentRepository paymentRepository;
    @GetMapping("/getallpayments")
    public ResponseEntity<List<PaymentTransaction>> getAllPayments()
    {
        try {
            List<PaymentTransaction> allPaymentList = new ArrayList<>(paymentRepository.findAll());
            if (allPaymentList.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(allPaymentList , HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getpaymentsbyorderid/{orderId}")
    public ResponseEntity<PaymentTransaction> getPaymentFromOrderId(@PathVariable Long orderId)
    {
        try{
            Optional<PaymentTransaction> paymentData = paymentRepository.findByOrderId(orderId);
            if (paymentData.isPresent())
                return new ResponseEntity<>(paymentData.get() , HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
