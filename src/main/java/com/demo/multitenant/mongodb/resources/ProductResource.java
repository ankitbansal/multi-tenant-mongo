package com.demo.multitenant.mongodb.resources;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.demo.multitenant.mongodb.models.Product;
import com.demo.multitenant.mongodb.service.ProductService;

@RestController
@Validated
@RequestMapping("/products")
public class ProductResource {
	
	@Autowired
	private ProductService productService;
    
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductResource.class);
	
	@PostMapping
    public ResponseEntity add(@RequestBody @Valid Product product, 
    		UriComponentsBuilder ucb, BindingResult bindingResult){
		LOGGER.info("Product name :" + product.getName());
		if(bindingResult.hasErrors()) {
			LOGGER.info("Request invalid");
			return ResponseEntity.badRequest().build();
		}
		Product createdProduct = productService.add(product);
		return ResponseEntity.created(ucb.path("/products/" + createdProduct.getId()).build().toUri()).build();
    }
}