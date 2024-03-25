package com.gultekingultas.paymentapidemo.Repository;

import com.gultekingultas.paymentapidemo.Entity.PaymentTransaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentTransaction , Long> {
    Optional<PaymentTransaction> findByOrderId(Long orderId);
    @Query("SELECT paymentType FROM PaymentTransaction GROUP BY paymentType ORDER BY COUNT(paymentType) DESC LIMIT 1")
    String findMostUsedPaymentType();

}
