package com.gultekingultas.paymentapidemo.Jobs;

import com.gultekingultas.paymentapidemo.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PaymentAnalyticsJob {

    final
    PaymentRepository paymentRepository;

    public PaymentAnalyticsJob(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Scheduled(fixedRate = 500000)
    public void denemeJob()
    {
        System.out.println("Most used payment method : "+paymentRepository.findMostUsedPaymentType());
    }


}
