package com.capgemini.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@EnableHystrix
@SpringBootApplication
@EnableDiscoveryClient
public class Lab1ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab1ProductApplication.class, args);
	}

}
