package com.kxg.middleground.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: szp
 * @Date: 2020/4/20 13:44
 * @Description: 沈泽鹏写点注释吧
 */
@Data
public class ProductDto {

    private Long id;


    private String appKey;

    /**
     * 项目名称
     */

    private String productName;

    private Long userId;

    private String phoneNumber;

    /**
     * 项目描述
     */
    private String content;


    private Date createTime;


    private String openid;

    private Date updateTime;

}
