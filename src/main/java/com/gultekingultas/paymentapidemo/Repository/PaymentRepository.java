package com.gultekingultas.paymentapidemo.Repository;

import com.gultekingultas.paymentapidemo.Entity.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentTransaction , Long> {
    //
}
