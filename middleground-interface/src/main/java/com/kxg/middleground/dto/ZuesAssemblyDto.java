package com.kxg.middleground.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: szp
 * @Date: 2020/4/20 10:34
 * @Description: 组件信息
 */
@Data
public class ZuesAssemblyDto {

    private Long id;


    private String assemblyName;


    private String appKey;


    private Date createTime;


    private Date updateTime;

    private Short status;


    private String shortIntroduce;


    private String assemblyDoc;


    private String createUser;


    private String updateUser;


    private String controllerApi;
}
