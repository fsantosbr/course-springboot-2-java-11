package com.fsantosinfo.webservicesspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsantosinfo.webservicesspringboot.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
	
}
