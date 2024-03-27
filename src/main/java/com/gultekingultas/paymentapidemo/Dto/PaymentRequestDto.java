package com.gultekingultas.paymentapidemo.Dto;

import com.gultekingultas.paymentapidemo.Annotations.ValidCardNumber;
import com.gultekingultas.paymentapidemo.Enum.PaymentType;
import com.gultekingultas.paymentapidemo.Util.CreditCardUtil;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NotNull
public class PaymentRequestDto{

    @NotNull
    private double amount;
    @NotNull
    private PaymentType paymentType;
    @NotNull
    private Long orderId;
    @NotNull
    @ValidCardNumber
    private String cardNumber;

   public String getCardNumber()
   {
       return CreditCardUtil.maskTheCardNumber(cardNumber);
   }

}
