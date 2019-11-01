package com.gurkan.dms.converter;

import com.gurkan.dms.bean.Document;
import com.gurkan.dms.bean.DocumentTemplate;
import com.gurkan.dms.interfaces.IConverter;

import java.util.Date;
import java.util.UUID;

@Deprecated
public class DocumentTemplateConverter implements IConverter<DocumentTemplate, Document> {

    @Override
    public Document convert(DocumentTemplate obj) {
        Document document = new Document();
        document.setDocumentType(obj.getDocumentType());
        document.setMetadatas(obj.getMetadatas());
        document.setName(UUID.randomUUID().toString());
        document.setCreateDate(new Date());
        document.setCreateTime(new Date());
        return document;
    }
}
