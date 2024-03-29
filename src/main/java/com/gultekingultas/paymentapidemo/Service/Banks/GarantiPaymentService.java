package com.gultekingultas.paymentapidemo.Service.Banks;

import com.gultekingultas.paymentapidemo.Dto.PaymentRequestDto;
import com.gultekingultas.paymentapidemo.Dto.PaymentResponseDto;
import com.gultekingultas.paymentapidemo.Service.Base.IPaymentService;
import com.gultekingultas.paymentapidemo.Service.PaymentTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("Garanti")
public class GarantiPaymentService implements IPaymentService {

    final
    PaymentTransactionService paymentTransactionService;

    public GarantiPaymentService(PaymentTransactionService paymentTransactionService) {
        this.paymentTransactionService = paymentTransactionService;
    }

    @Override
    public PaymentResponseDto processPayment(PaymentRequestDto paymentRequestDto) {
        PaymentResponseDto paymentResponseDto = new PaymentResponseDto(
                paymentRequestDto.getAmount(),
                paymentRequestDto.getPaymentType(),
                paymentRequestDto.getOrderId()
        );
        paymentTransactionService.createPaymentTransactionFromPaymentRequest(paymentRequestDto , paymentResponseDto.getPaymentStatus());
        return paymentResponseDto;
    }


}
