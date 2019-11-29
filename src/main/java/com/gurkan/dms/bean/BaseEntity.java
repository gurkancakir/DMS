package com.gurkan.dms.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    private String id;
    private String status;

    @JsonFormat(pattern="yyyyMMdd", timezone = "Europe/Istanbul")
    private Date createDate;

    @JsonFormat(pattern="HHmmss", timezone = "Europe/Istanbul")
    private Date createTime;

    private String insertUser;

    @JsonFormat(pattern="yyyyMMdd", timezone = "Europe/Istanbul")
    private Date updateDate;

    @JsonFormat(pattern="HHmmss", timezone = "Europe/Istanbul")
    private Date updateTime;

    private String updateUser;
}
