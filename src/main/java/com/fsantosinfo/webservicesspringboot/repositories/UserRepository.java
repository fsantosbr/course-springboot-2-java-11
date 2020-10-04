package com.fsantosinfo.webservicesspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsantosinfo.webservicesspringboot.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	
}
