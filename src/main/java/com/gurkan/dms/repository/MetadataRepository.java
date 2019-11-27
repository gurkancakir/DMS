package com.gurkan.dms.repository;

import com.gurkan.dms.bean.Metadata;
import org.springframework.stereotype.Repository;

@Repository
public interface MetadataRepository extends BaseMongoRepository<Metadata, String> {

    Metadata findByName(String name);
}
