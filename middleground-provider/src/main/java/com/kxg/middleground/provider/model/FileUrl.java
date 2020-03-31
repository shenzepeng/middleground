package com.kxg.middleground.provider.model;

import lombok.Data;

import java.util.Date;
@Data
public class FileUrl {
    private Long id;

    private String imgUrl;

    private String addIp;

    private Date createTime;

    private Date updateTime;

    private Short status;
}
