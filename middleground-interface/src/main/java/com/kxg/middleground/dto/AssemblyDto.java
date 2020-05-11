package com.kxg.middleground.dto;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import java.util.Date;

/**
 * 要写注释呀
 */
@Data
public class AssemblyDto {
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


    private String imgIcon;


    private String imgHeader;
}
