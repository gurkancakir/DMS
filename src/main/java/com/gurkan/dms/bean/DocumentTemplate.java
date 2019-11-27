package com.gurkan.dms.bean;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "DOCUMENT_TEMPLATE")
@Data
public class DocumentTemplate {

    @Id
    private String id;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "type_id", nullable = false)
    private DocumentType documentType;

    private List<Metadata> metadatas = new ArrayList<>();
}
