package com.gultekingultas.paymentapidemo.Service;

import com.gultekingultas.paymentapidemo.Dto.PaymentRequestDto;
import com.gultekingultas.paymentapidemo.Dto.PaymentTransactionDto;
import com.gultekingultas.paymentapidemo.Entity.PaymentTransaction;
import com.gultekingultas.paymentapidemo.Enum.PaymentType;
import com.gultekingultas.paymentapidemo.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentTransactionService {

    final
    PaymentRepository paymentRepository;

    public PaymentTransactionService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void createPaymentTransactionFromPaymentRequest(PaymentRequestDto paymentRequestDto , boolean isPaymentStatusOK)
    {
        PaymentTransaction paymentTransaction = new PaymentTransaction();
        paymentTransaction.setPaymentType(paymentRequestDto.getPaymentType().toString());
        paymentTransaction.setAmount(paymentRequestDto.getAmount());
        paymentTransaction.setOrderId(paymentRequestDto.getOrderId());
        paymentTransaction.setCardNumber(paymentRequestDto.getCardNumber());
        paymentTransaction.setOrderStatus(isPaymentStatusOK);
        //
        paymentRepository.save(paymentTransaction);
    }

    public List<PaymentTransactionDto> getAllPayments() throws Exception {
        try {
            List<PaymentTransactionDto> allPaymentList = new ArrayList<>();
            List<PaymentTransaction> paymentTransactionList = new ArrayList<>(paymentRepository.findAll());
            for (PaymentTransaction paymentTransaction : paymentTransactionList) {
                PaymentTransactionDto paymentTransactionDto = new PaymentTransactionDto();
                paymentTransactionDto.setPaymentStatus(paymentTransaction.isOrderStatus());
                paymentTransactionDto.setPaymentType(PaymentType.valueOf(paymentTransaction.getPaymentType()));
                paymentTransactionDto.setOrderId(paymentTransaction.getOrderId());
                paymentTransactionDto.setCardNumber(paymentTransaction.getCardNumber());
                paymentTransactionDto.setAmount(paymentTransaction.getAmount());
                allPaymentList.add(paymentTransactionDto);
            }
            return allPaymentList;
        }
        catch (Exception e)
        {
            throw new Exception();
        }
    }

    public PaymentTransactionDto getPaymentFromOrderId(Long orderId) throws Exception
    {
        try{
            PaymentTransactionDto paymentTransactionDto = new PaymentTransactionDto();
            Optional<PaymentTransaction> paymentTransactionData = paymentRepository.findByOrderId(orderId);
            if (paymentTransactionData.isPresent())
            {
                PaymentTransaction paymentTransaction = paymentTransactionData.get();
                paymentTransactionDto.setPaymentStatus(paymentTransaction.isOrderStatus());
                paymentTransactionDto.setPaymentType(PaymentType.valueOf(paymentTransaction.getPaymentType()));
                paymentTransactionDto.setAmount(paymentTransaction.getAmount());
                paymentTransactionDto.setOrderId(paymentTransaction.getOrderId());
                paymentTransactionDto.setCardNumber(paymentTransaction.getCardNumber());
            }
            return paymentTransactionDto;
        }catch (Exception e)
        {
            throw new Exception();
        }
    }

}
