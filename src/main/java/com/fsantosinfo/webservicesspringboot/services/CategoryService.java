package com.fsantosinfo.webservicesspringboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsantosinfo.webservicesspringboot.entities.Category;
import com.fsantosinfo.webservicesspringboot.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	// @Service - annotation to register a component. Every class that will be used for dependency injection need to be registered in the Spring
	// there're others annotation to register, like @Component. We're using Service cause this class is a service.
	
	@Autowired
	private CategoryRepository repository;
	// @AutoWired is an annotation that makes dependency injection (week) to other class
	
	public List<Category> findAll(){
		return repository.findAll(); // findAll() is method from JpaRepository class
	}
	// This service pass the call of a method to the repositories layer
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}

