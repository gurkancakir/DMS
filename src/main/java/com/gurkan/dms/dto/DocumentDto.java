package com.gurkan.dms.dto;

import com.gurkan.dms.bean.Metadata;
import lombok.Data;

import java.util.List;

@Data
public class DocumentDto {

    private String content;
    private String mimeType;
    private String authorName;
    private String documentType;
    private List<Metadata> metadatas;
}
