package com.gurkan.dms.bean;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DOCUMENT_TYPE")
@Data
public class DocumentType extends BaseEntity {

    private String type;

  /*  @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "document_type_rel",
            joinColumns = { @JoinColumn(name = "type_id") },
            inverseJoinColumns = { @JoinColumn(name = "document_id") })
    private List<Document> documents = new ArrayList<>();*/
}
