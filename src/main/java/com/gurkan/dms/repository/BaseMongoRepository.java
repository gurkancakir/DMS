package com.gurkan.dms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseMongoRepository<T, V> extends MongoRepository<T, V> {

}
