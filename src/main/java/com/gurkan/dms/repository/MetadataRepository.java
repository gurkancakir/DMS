package com.gurkan.dms.repository;

import com.gurkan.dms.bean.Metadata;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetadataRepository extends MongoRepository<Metadata, String> {

    Metadata findByName(String name);
}
