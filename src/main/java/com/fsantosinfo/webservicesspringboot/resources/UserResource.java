package com.fsantosinfo.webservicesspringboot.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fsantosinfo.webservicesspringboot.entities.User;
import com.fsantosinfo.webservicesspringboot.services.UserService;

// This class will delivery a web resource related to User. It's a Rest controller

@RestController // this is an annotation to create RESTful web services
@RequestMapping(value = "/users") // we use to map the http requests. Using the address (e.g.) localhost:8080/users, it'll call the following method
public class UserResource {

	@Autowired
	private UserService service;
	// @AutoWired is an annotation that makes dependency injection (week) to other class
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	// annotation for mapping HTTP GET requests onto specific handler methods.
	// Specifically, @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
	// ResponseEntity<T> is an specific type to return web requests 
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	// In this example, we use @PathVariable annotation to extract the templated part of the URI represented by the variable {id}.
	// A simple GET request to /{id} will invoke findById with the extracted id value
	
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	
	// read the next comments for the following method
	@GetMapping("/testing")
	public ResponseEntity<String> olaString(){
		return ResponseEntity.ok().body("Olá");
	}
	/* This method is here only for a test. I'll delete in the finals of this project.
	 *  We can only have one method with the annotation @GetMapping. That method will load when this class will be requested (localhost:8080/users).
	 *  The others GetMapping annotation have their own path in the args, e.g. @GetMapping("/testing"), (localhost:8080/users/testing).
	 */
}
