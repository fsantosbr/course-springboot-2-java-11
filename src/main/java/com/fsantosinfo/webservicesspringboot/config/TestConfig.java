package com.fsantosinfo.webservicesspringboot.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fsantosinfo.webservicesspringboot.entities.User;
import com.fsantosinfo.webservicesspringboot.repositories.UserRepository;

//A class for configuration that is specific for test profile (file created in src/main/resources/application-test.properties)

@Configuration 
@Profile("test")
public class TestConfig implements CommandLineRunner {

	// @Configuration - Letting the Spring knows that this is an specific class of configuration 
	// @Profile("test") -  Letting the Spring knows that this is an specific configuration for the test profile - the arg "test" must be the same we set in the application.properties
	
	@Autowired
	private UserRepository userRepository;
	// @AutoWired is an annotation that makes dependencies (week) to other class

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2)); // saveAll() is method from JpaRepository class
	}	
	// CommandLineRunner: an interface to execute the dependency when the program starts.
	// This will implement the run method. Everything inside of it will be executed when the program starts

}
