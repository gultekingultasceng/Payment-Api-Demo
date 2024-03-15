package com.gultekingultas.paymentapidemo.Util;

public class CreditCardUtil {
    public static String maskTheCardNumber(String cardNumber) {
        return "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
    }
}
