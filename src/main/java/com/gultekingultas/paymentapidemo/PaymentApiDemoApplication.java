package com.gultekingultas.paymentapidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PaymentApiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentApiDemoApplication.class, args);
	}
}
