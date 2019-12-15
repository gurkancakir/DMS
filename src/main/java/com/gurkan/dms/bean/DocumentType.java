package com.gurkan.dms.bean;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DOCUMENT_TYPE")
@Data
public class DocumentType extends BaseEntity {

    private String type;
}
