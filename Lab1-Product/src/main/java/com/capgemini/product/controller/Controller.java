package com.capgemini.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.product.dao.ProductDao;
import com.capgemini.product.dto.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;


@RestController
@RequestMapping(path = "/product")
public class Controller {
	@Autowired
	ProductDao ratingSer;

	
	@GetMapping(value = "/test")
	 @HystrixCommand(fallbackMethod = "fallback_ping", commandProperties = {
		      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
		   })
	public String pingMe() {
		return "Ping Successful At Product API";
	}
	public String fallback_ping() {
		return "Oh! An Error occured.";
	}
	
	
	@GetMapping(value = "/getProduct/{id}")
	public Product getCatalog(@PathVariable(value = "id") int id) {
		return ratingSer.findById(id).get();
	}
	@GetMapping(value = "/getAllProduct")
	public Iterable<Product> getAllProduct() {
		return ratingSer.findAll();
	}
	@PostMapping(value = "/updateCatalog")
	public Product updateCatalog(@RequestBody Product mr) {
		return ratingSer.save(mr);
	}
	@PostMapping(value= "/addCatalog")
	public Product addCatalog(@RequestBody Product mr) {
		return ratingSer.save(mr);
	}
	
	@DeleteMapping(value = "delete/{id}")
	public void deleteCatalog(@PathVariable(value = "id") int id) {
		ratingSer.deleteById(id);
	}

	
}
