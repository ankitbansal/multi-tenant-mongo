package com.demo.multitenant.mongodb.models;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="product")
public class Product {
	@Id
	private String id;
	@NotNull
	private String name;
	private String description;
}
