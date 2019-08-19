package com.turvo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turvo.dao.bean.Product;
	
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

		
}
