package com.gurkan.dms.service;

import com.gurkan.dms.bean.Document;
import com.gurkan.dms.repository.DocumentRepository;
import com.gurkan.dms.util.DMSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    public Document add(Document document) {
        document.setCreateDate(DMSUtil.dateNow());
        document.setCreateTime(DMSUtil.timeNow());
        document.setInsertUser(DMSUtil.sessionUser());
        return documentRepository.save(document);
    }

    public Document update(Document document) {
        document.setUpdateDate(DMSUtil.dateNow());
        document.setUpdateTime(DMSUtil.timeNow());
        document.setUpdateUser(DMSUtil.sessionUser());
        return documentRepository.save(document);
    }

    public List<Document> list() {
        return documentRepository.findAll();
    }

    public List<Document> findByMetadatasNameAndMetadatasValue(String name, String value) {
        return documentRepository.findByMetadatasNameAndMetadatasValue(name, value);
    }

    public List<Document> findByDocumentTypeType(String documentType) {
        return documentRepository.findByDocumentTypeType(documentType);
    }
}
