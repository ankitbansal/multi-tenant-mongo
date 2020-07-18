package com.demo.multitenant.mongodb;

import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import com.mongodb.client.MongoDatabase;

public class MultiTenantMongoDBFactory extends SimpleMongoClientDatabaseFactory {

	public MultiTenantMongoDBFactory(String connectionString) {
		super(connectionString);
	}

	@Override
	public MongoDatabase getMongoDatabase() throws DataAccessException {
		return getMongoDatabase("tenantdefault");
	}
}
