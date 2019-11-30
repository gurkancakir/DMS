package com.gurkan.dms.service;

import com.gurkan.dms.bean.DocumentType;
import com.gurkan.dms.repository.DocumentTypeRepository;
import com.gurkan.dms.util.DMSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTypeService {

    @Autowired
    DocumentTypeRepository documentTypeRepository;

    public DocumentType add(DocumentType documentType) {
        documentType.setCreateDate(DMSUtil.dateNow());
        documentType.setCreateTime(DMSUtil.timeNow());
        documentType.setInsertUser(DMSUtil.sessionUser());
        return documentTypeRepository.save(documentType);
    }

    public DocumentType update(DocumentType documentType) {
        documentType.setUpdateDate(DMSUtil.dateNow());
        documentType.setUpdateTime(DMSUtil.timeNow());
        documentType.setUpdateUser(DMSUtil.sessionUser());
        return documentTypeRepository.save(documentType);
    }

    public List<DocumentType> list() {
        return documentTypeRepository.findAll();
    }

    public DocumentType findByType(String documentType) {
        return documentTypeRepository.findByType(documentType);
    }
}
