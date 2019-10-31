package com.gurkan.dms.repository;

import com.gurkan.dms.bean.DocumentTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTemplateRepository extends MongoRepository<DocumentTemplate, String> {

    DocumentTemplate findByDocumentTypeType(String documentType);
}
