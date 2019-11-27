package com.gurkan.dms.repository;

import com.gurkan.dms.bean.DocumentType;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypeRepository extends BaseMongoRepository<DocumentType, String> {

    DocumentType findByType(String documentType);
}
