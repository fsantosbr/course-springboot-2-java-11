package com.fsantosinfo.webservicesspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsantosinfo.webservicesspringboot.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	
}
