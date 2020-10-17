package com.fsantosinfo.webservicesspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsantosinfo.webservicesspringboot.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	
}
