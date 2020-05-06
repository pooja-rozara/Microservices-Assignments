package com.capgemini.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
@RestController
@RequestMapping("/")
public class Controller {

	@GetMapping(value = "/test")
	 @HystrixCommand(fallbackMethod = "fallback_ping", commandProperties = {
		      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
		   })
	public String pingMe() {
		return "Ping Successful At Product Cart API";
	}
	public String fallback_ping() {
		return "Oh! An Error occured.";
	}
}
