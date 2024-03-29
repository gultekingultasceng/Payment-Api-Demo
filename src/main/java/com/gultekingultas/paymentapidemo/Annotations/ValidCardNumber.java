package com.gultekingultas.paymentapidemo.Annotations;

import com.gultekingultas.paymentapidemo.Validators.CardNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CardNumberValidator.class)
public @interface ValidCardNumber {
    String message() default "invalid card number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
