package com.fsantosinfo.webservicesspringboot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsantosinfo.webservicesspringboot.entities.Category;
import com.fsantosinfo.webservicesspringboot.services.CategoryService;

// This class will delivery a web resource related to Category. It's a Rest controller

@RestController // this is an annotation to create RESTful web services
@RequestMapping(value = "/categories") // we use to map the http requests. Using the address (e.g.) localhost:8080/categories, it'll call the following method
public class CategoryResource {

	@Autowired
	private CategoryService service;
	// @AutoWired is an annotation that makes dependency injection (week) to other class
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	// annotation for mapping HTTP GET requests onto specific handler methods.
	// Specifically, @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
	// ResponseEntity<T> is an specific type to return web requests 
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	// In this example, we use @PathVariable annotation to extract the templated part of the URI represented by the variable {id}.
	// A simple GET request to /{id} will invoke findById with the extracted id value
	
	
}
