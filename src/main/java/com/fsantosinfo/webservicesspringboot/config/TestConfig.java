package com.fsantosinfo.webservicesspringboot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fsantosinfo.webservicesspringboot.entities.Category;
import com.fsantosinfo.webservicesspringboot.entities.Order;
import com.fsantosinfo.webservicesspringboot.entities.User;
import com.fsantosinfo.webservicesspringboot.entities.enums.OrderStatus;
import com.fsantosinfo.webservicesspringboot.repositories.CategoryRepository;
import com.fsantosinfo.webservicesspringboot.repositories.OrderRepository;
import com.fsantosinfo.webservicesspringboot.repositories.UserRepository;

//An auxiliary class for configuration that is specific for test profile (file created in src/main/resources/application-test.properties)

@Configuration 
@Profile("test")
public class TestConfig implements CommandLineRunner {

	// @Configuration - Letting the Spring knows that this is an specific class of configuration 
	// @Profile("test") -  Letting the Spring knows that this is an specific configuration for the test profile - the arg "test" must be the same we set in the application.properties
	
	@Autowired
	private UserRepository userRepository;
	// @AutoWired is an annotation that makes dependency injection (week) to other class
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.CANCELED, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.DELIVERED, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, u1);		
		
		userRepository.saveAll(Arrays.asList(u1, u2)); // saveAll() is method from JpaRepository class
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
	}	
	// CommandLineRunner: an interface to execute anything when the program starts.
	// This will implement the run method. Everything inside of it will be executed when the program starts

}
