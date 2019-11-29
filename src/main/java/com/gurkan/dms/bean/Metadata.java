package com.gurkan.dms.bean;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "METADATA")
@Data
public class Metadata extends BaseEntity {

    private String name;
    private String value;
}
