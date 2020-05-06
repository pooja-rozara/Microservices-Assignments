package com.capgemini.count.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.count.dao.CountDao;
import com.capgemini.count.dto.Count;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;


@RestController
@RequestMapping(path = "/product")
public class Controller {
	@Autowired
	CountDao repo;

	@GetMapping(value = "/test")
	 @HystrixCommand(fallbackMethod = "fallback_ping", commandProperties = {
		      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
		   })
	public String pingMe() {
		return "Ping Successful At Product Stock API";
	}
	public String fallback_ping() {
		return "Oh! An Error occured.";
	}
	
	
	@GetMapping(value = "/getCount/{id}")
	public Count getCatalog(@PathVariable(value = "id") int id) {
		return repo.findById(id).get();
	}
	@GetMapping(value = "/getAllCount")
	public Iterable<Count> getAllCount() {
		return repo.findAll();
	}
	@PostMapping(value = "/updateCount")
	public Count updateCatalog(@RequestBody Count mr) {
		return repo.save(mr);
	}
	@PostMapping(value= "/addCount")
	public Count addCatalog(@RequestBody Count mr) {
		return repo.save(mr);
	}
	
	@DeleteMapping(value = "delete/{id}")
	public void deleteCatalog(@PathVariable(value = "id") int id) {
		repo.deleteById(id);
	}

	
}
