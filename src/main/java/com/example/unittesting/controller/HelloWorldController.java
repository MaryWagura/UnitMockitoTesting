package com.example.unittesting.controller;

import com.example.unittesting.model.Item;
import com.example.unittesting.service.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/hello-world")
	public String helloWorld(){
		return "Hello World";
	}

	@GetMapping("/dummy-item")
	public Item dummyItem(){
			return new Item(1, "Ball", 10, 100);
	}

	@GetMapping("/dummy-items")
	public Item dummyItems(){
		return new Item(1, "Ball", 10, 100);
	}

	@GetMapping("/dummy-items1")
	public Item dummyItems1(){
		return new Item(1, "Ball", 10, 100);
	}

}
