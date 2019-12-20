package com.gurkan.dms.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    private String id;
    private String status;

    @JsonFormat(pattern = "yyyyMMdd", timezone = "Europe/Istanbul")
    private LocalDate createDate;

    @JsonFormat(pattern = "HHmmss", timezone = "Europe/Istanbul")
    private LocalTime createTime;

    private String insertUser;

    @JsonFormat(pattern = "yyyyMMdd", timezone = "Europe/Istanbul")
    private LocalDate updateDate;

    @JsonFormat(pattern = "HHmmss", timezone = "Europe/Istanbul")
    private LocalTime updateTime;

    private String updateUser;
}
