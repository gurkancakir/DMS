package com.gurkan.dms.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@org.springframework.data.mongodb.core.mapping.Document(collection = "DOCUMENT")
@Data
public class Document {

    @Id
    private String id;
    private String name;

    @JsonFormat(pattern="yyyyMMdd", timezone = "Europe/Istanbul")
    private Date createDate;

    @JsonFormat(pattern="HHmmss", timezone = "Europe/Istanbul")
    private Date createTime;

    private String authorName;
    private String mimeType;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "type_id", nullable = false)
    private DocumentType documentType;

    /*@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "documents")*/
    List<Metadata> metadatas = new ArrayList<>();
}
