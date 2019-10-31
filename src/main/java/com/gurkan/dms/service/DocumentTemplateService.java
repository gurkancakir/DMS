package com.gurkan.dms.service;

import com.gurkan.dms.bean.DocumentTemplate;
import com.gurkan.dms.repository.DocumentTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTemplateService {

    @Autowired
    DocumentTemplateRepository documentTemplateRepository;

    public DocumentTemplate add(DocumentTemplate documentTemplate) {
        return documentTemplateRepository.save(documentTemplate);
    }

    public List<DocumentTemplate> list() {
        return documentTemplateRepository.findAll();
    }

    public DocumentTemplate findByDocumentTypeType(String documentType) {
        return documentTemplateRepository.findByDocumentTypeType(documentType);
    }
}
