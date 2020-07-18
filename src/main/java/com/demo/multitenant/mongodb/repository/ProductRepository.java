package com.demo.multitenant.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.multitenant.mongodb.models.Product;

public interface ProductRepository  extends MongoRepository<Product, String>{
	
}
