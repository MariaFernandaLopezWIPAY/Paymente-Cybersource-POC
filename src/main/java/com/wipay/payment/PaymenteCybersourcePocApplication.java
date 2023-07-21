package com.wipay.payment;

import com.wipay.payment.cybersource.config.ConfigurationInputProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class PaymenteCybersourcePocApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymenteCybersourcePocApplication.class, args);
	}

}
