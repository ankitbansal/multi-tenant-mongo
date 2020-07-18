package com.demo.multitenant.mongodb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MultiTenantMongoDBConfiguration {

	@Value("${spring.data.mongodb.uri}")
	private String connectionString;
	
	@Bean
    @Primary
    public MongoDatabaseFactory mongoDbFactory() {
       return new MultiTenantMongoDBFactory(connectionString);
    }

    @Bean
    @Primary
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }
}
