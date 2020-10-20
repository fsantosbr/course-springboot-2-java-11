package com.fsantosinfo.webservicesspringboot.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fsantosinfo.webservicesspringboot.entities.User;
import com.fsantosinfo.webservicesspringboot.repositories.UserRepository;
import com.fsantosinfo.webservicesspringboot.services.exceptions.DatabaseException;
import com.fsantosinfo.webservicesspringboot.services.exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		try{
			User entity = repository.getOne(id);		
			/* getOne() method won't make any access to the db, it'll only keep the object checked for the jpa and then we can perform a task.
			 * It's better to use it instead of findById() that will actually access the data base
			 */
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());		
	}
}

