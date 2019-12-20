package com.gurkan.dms.bean;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@org.springframework.data.mongodb.core.mapping.Document(collection = "DOCUMENT")
@Data
public class Document extends BaseEntity {

    private String name;

    private String authorName;
    private String mimeType;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "type_id", nullable = false)
    private DocumentType documentType;

    List<Metadata> metadatas = new ArrayList<>();
}
