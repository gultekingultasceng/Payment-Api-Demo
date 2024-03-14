package com.gultekingultas.paymentapidemo.Entity;

import com.gultekingultas.paymentapidemo.Utility.CardUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PaymentTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double amount;
    private String paymentType;
    private Long orderId;
    private String paymentDetails;
    private String cardNumber;
    private boolean orderStatus;
    public void setCardNumber(String cardNumber) {
        this.cardNumber = CardUtil.maskTheCardNumber(cardNumber);
    }


}
