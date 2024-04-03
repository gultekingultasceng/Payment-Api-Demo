package com.gultekingultas.paymentapidemo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PaymentTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    @Transient
    private String fullName;
    private double amount;
    private String paymentType;
    private Long orderId;
    private String cardNumber;
    private boolean orderStatus;

    public String getFullName()
    {
        return name+" "+surname;
    }
}
