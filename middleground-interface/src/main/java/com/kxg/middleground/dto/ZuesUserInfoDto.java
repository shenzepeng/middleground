package com.kxg.middleground.dto;

import lombok.Data;

import java.util.Date;
@Data
public class ZuesUserInfoDto {

    private Long id;


    private String phoneNumber;

    private String password;

    private Short type;


    private Date createTime;


    private Date updateTime;

    private String requestId;

    private String headerUrl;


    private String nickName;


    private String openId;
}
