package com.gurkan.dms.service;

import com.gurkan.dms.bean.Document;
import com.gurkan.dms.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    public Document add(Document document) {
        return documentRepository.save(document);
    }

    public List<Document> list() {
        return documentRepository.findAll();
    }

    public List<Document> findByMetadatasNameAndMetadatasValue(String name, String value) {
        return documentRepository.findByMetadatasNameAndMetadatasValue(name, value);
    }
}
