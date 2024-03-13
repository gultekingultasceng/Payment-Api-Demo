package com.gultekingultas.paymentapidemo.Utility;

public class CardUtil {
    public static String maskTheCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.length() < 4) {
            throw new IllegalArgumentException("Invalid Card Number");
        }
        String maskedCardNumber = "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
        return maskedCardNumber;
    }
}
