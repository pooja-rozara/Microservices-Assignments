package com.capgemini.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@SpringBootApplication
@EnableEurekaServer
public class Lab1SunHomeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab1SunHomeApiApplication.class, args);
	}

}
