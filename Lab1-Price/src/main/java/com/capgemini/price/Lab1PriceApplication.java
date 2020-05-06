package com.capgemini.price;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Lab1PriceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab1PriceApplication.class, args);
	}

}
