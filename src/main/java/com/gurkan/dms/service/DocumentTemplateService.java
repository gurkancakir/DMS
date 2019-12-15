package com.gurkan.dms.service;

import com.gurkan.dms.bean.DocumentTemplate;
import com.gurkan.dms.repository.DocumentTemplateRepository;
import com.gurkan.dms.util.DMSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTemplateService {

    @Autowired
    DocumentTemplateRepository documentTemplateRepository;

    public DocumentTemplate add(DocumentTemplate documentTemplate) {
        documentTemplate.setCreateDate(DMSUtil.dateNow());
        documentTemplate.setCreateTime(DMSUtil.timeNow());
        documentTemplate.setInsertUser(DMSUtil.sessionUser());
        return documentTemplateRepository.save(documentTemplate);
    }

    public DocumentTemplate update(DocumentTemplate documentTemplate) {
        documentTemplate.setUpdateDate(DMSUtil.dateNow());
        documentTemplate.setUpdateTime(DMSUtil.timeNow());
        documentTemplate.setUpdateUser(DMSUtil.sessionUser());
        return documentTemplateRepository.save(documentTemplate);
    }

    public List<DocumentTemplate> list() {
        return documentTemplateRepository.findAll();
    }

    public DocumentTemplate findByDocumentTypeType(String documentType) {
        return documentTemplateRepository.findByDocumentTypeType(documentType);
    }
}
