package com.gurkan.dms.dto;

import com.gurkan.dms.bean.Metadata;
import lombok.Data;

import java.util.List;

@Data
public class DocumentTemplateDto {

    private String type;
    private List<Metadata> metadatas;
}
