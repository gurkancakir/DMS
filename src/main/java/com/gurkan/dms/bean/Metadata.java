package com.gurkan.dms.bean;

import lombok.Data;

import javax.persistence.Id;

@org.springframework.data.mongodb.core.mapping.Document(collection = "METADATA")
@Data
public class Metadata {

    @Id
    private String id;
    private String name;
    private String value;
}
