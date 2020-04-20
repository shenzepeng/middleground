package com.kxg.middleground.request;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: szp
 * @Date: 2020/4/20 15:19
 * @Description: 添加
 */
@Data
public class AddProductRequest {
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


    private String openid;



}
