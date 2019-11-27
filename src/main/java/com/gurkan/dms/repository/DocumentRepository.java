package com.gurkan.dms.repository;

import com.gurkan.dms.bean.Document;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends BaseMongoRepository<Document, String> {

    List<Document> findByMetadatasNameAndMetadatasValue(String name, String value);
    List<Document> findByDocumentTypeType(String documentType);
}
