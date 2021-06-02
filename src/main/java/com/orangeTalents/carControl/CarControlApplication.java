package com.orangeTalents.carControl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CarControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarControlApplication.class, args);
	}

}
