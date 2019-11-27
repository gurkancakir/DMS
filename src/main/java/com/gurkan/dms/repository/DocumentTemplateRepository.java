package com.gurkan.dms.repository;

import com.gurkan.dms.bean.DocumentTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTemplateRepository extends BaseMongoRepository<DocumentTemplate, String> {

    DocumentTemplate findByDocumentTypeType(String documentType);
}
