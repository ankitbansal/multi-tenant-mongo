package com.demo.multitenant.mongodb.config;

import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.mongodb.client.MongoDatabase;

public class MultiTenantMongoDBFactory extends SimpleMongoClientDatabaseFactory {

	public MultiTenantMongoDBFactory(String connectionString) {
		super(connectionString);
	}

	@Override
	public MongoDatabase getMongoDatabase() throws DataAccessException {
		Object tenantValue = RequestContextHolder.getRequestAttributes().
				getAttribute("tenantName", RequestAttributes.SCOPE_REQUEST);
		if(tenantValue != null) {
			return getMongoDatabase(tenantValue.toString());
		}
		return super.getMongoDatabase();
	}
}
