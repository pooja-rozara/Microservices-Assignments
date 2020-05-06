package com.capgemini.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.cart.dao.CartDao;
import com.capgemini.cart.dto.Cart;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@EnableHystrixDashboard
@EnableHystrix
@RestController
@RequestMapping(path = "/product")
public class Controller {
	@Autowired
	CartDao repo;
	
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
	
	
	
	@GetMapping(value = "/getCart/{id}")
	public Cart getCatalog(@PathVariable(value = "id") int id) {
		return repo.findById(id).get();
	}
	@GetMapping(value = "/getAllCart")
	public Iterable<Cart> getAllCart() {
		return repo.findAll();
	}
	@PostMapping(value = "/updateCart")
	public Cart updateCart(@RequestBody Cart mr) {
		return repo.save(mr);
	}
	@PostMapping(value= "/addCart")
	public Cart addNewCart(@RequestBody Cart mr) {
		return repo.save(mr);
	}
	
	@DeleteMapping(value = "delete/{id}")
	public void deleteCatalog(@PathVariable(value = "id") int id) {
		repo.deleteById(id);
	}

	
}
