package com.hardik.countriesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class ContriesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContriesServiceApplication.class, args);
	}
	
}
