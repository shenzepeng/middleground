package com.kxg.middleground.request;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: szp
 * @Date: 2020/4/20 11:13
 * @Description: 沈泽鹏写点注释吧
 */
@Data
public class UpdateAssemblyRequest   {
    private Long id;


    private String assemblyName;


    private String appKey;


    private Short status;


    private String shortIntroduce;


    private String assemblyDoc;


    private String createUser;


    private String updateUser;


    private String controllerApi;
}
