package com.gultekingultas.paymentapidemo.Dto;

import com.gultekingultas.paymentapidemo.Annotations.ValidCardNumber;
import com.gultekingultas.paymentapidemo.Enum.PaymentType;
import com.gultekingultas.paymentapidemo.Util.CreditCardUtil;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentRequestDto {

    private double amount;
    private PaymentType paymentType;
    private Long orderId;
    @ValidCardNumber
    private String cardNumber;

   public String getCardNumber()
   {
       return CreditCardUtil.maskTheCardNumber(cardNumber);
   }

}
