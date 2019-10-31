package com.gurkan.dms.service;

import com.gurkan.dms.bean.DocumentType;
import com.gurkan.dms.repository.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTypeService {

    @Autowired
    DocumentTypeRepository documentTypeRepository;

    public DocumentType add(DocumentType documentType) {
        return documentTypeRepository.save(documentType);
    }

    public List<DocumentType> list() {
        return documentTypeRepository.findAll();
    }

    public DocumentType findByType(String documentType) {
        return documentTypeRepository.findByType(documentType);
    }
}
