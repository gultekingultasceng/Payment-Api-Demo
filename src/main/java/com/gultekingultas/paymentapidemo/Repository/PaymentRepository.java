package com.gultekingultas.paymentapidemo.Repository;

import com.gultekingultas.paymentapidemo.Entity.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentTransaction , Long> {
    Optional<PaymentTransaction> findByOrderId(Long orderId);
}
