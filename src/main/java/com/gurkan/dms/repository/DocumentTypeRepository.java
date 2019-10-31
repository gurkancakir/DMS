package com.gurkan.dms.repository;

import com.gurkan.dms.bean.DocumentType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypeRepository extends MongoRepository<DocumentType, String> {

    DocumentType findByType(String documentType);
}
