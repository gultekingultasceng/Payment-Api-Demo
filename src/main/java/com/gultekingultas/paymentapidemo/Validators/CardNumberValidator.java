package com.gultekingultas.paymentapidemo.Validators;

import com.gultekingultas.paymentapidemo.Annotations.ValidCardNumber;
import com.gultekingultas.paymentapidemo.Exception.InvalidCardNumberException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class CardNumberValidator implements ConstraintValidator<ValidCardNumber, String>{

    String message;

    @Override
    public void initialize(ValidCardNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext){
        if (!org.apache.commons.validator.routines.checkdigit.LuhnCheckDigit.LUHN_CHECK_DIGIT.isValid(s))
            throw new InvalidCardNumberException(message);
        return true;
    }
}
