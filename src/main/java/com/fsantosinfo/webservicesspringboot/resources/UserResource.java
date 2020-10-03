package com.fsantosinfo.webservicesspringboot.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsantosinfo.webservicesspringboot.entities.User;

// This class will delivery a web resource related to User






@RestController // this is an annotation to create RESTful web services
@RequestMapping(value = "/users") // we use to map the http requests. Using the address (e.g.) localhost:8080/users, it'll call the following method
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Mario", "Mario@gmail.com", "11965398826", "senhaSenha");
		return ResponseEntity.ok().body(u);
	}
	// annotation for mapping HTTP GET requests onto specific handler methods.
	// Specifically, @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
	// ResponseEntity<T> is an specific type to return web requests 
}
