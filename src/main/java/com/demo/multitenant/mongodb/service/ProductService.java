package com.demo.multitenant.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.multitenant.mongodb.models.Product;
import com.demo.multitenant.mongodb.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product add(Product product) {
		return productRepository.save(product);
	}

	public List<Product> getAll() {
		return productRepository.findAll();
	}
}
