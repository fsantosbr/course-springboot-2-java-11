package com.fsantosinfo.webservicesspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsantosinfo.webservicesspringboot.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	
}
