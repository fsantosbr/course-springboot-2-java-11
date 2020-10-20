package com.fsantosinfo.webservicesspringboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsantosinfo.webservicesspringboot.entities.User;
import com.fsantosinfo.webservicesspringboot.repositories.UserRepository;

@Service
public class UserService {
	
	// @Service - annotation to register a component. Every class that will be used for dependency injection need to be registered in the Spring
	// there're others annotation to register, like @Component. We're using Service cause this class is a service.
	
	@Autowired
	private UserRepository repository;
	// @AutoWired is an annotation that makes dependency injection (week) to other class
	
	public List<User> findAll(){
		return repository.findAll(); // findAll() is method from JpaRepository class
	}
	// This service pass the call of a method to the repositories layer
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getOne(id);
		/* getOne() method won't make any access to the db, it'll only keep the object checked for the jpa and then we can perform a task.
		 * It's better to use it instead of findById() that will actually access the data base
		 */
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());		
	}
}

