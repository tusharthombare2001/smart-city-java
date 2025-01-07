package com.smart_city;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.smart_city")
public class SmartCityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartCityApplication.class, args);
	}

}
