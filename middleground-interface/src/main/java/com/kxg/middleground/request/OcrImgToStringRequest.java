package com.kxg.middleground.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author mac
 * @Auther: szp
 * @Date: 2020/4/8 17:31
 * @Description: 图片识别
 */
@Data
public class OcrImgToStringRequest implements Serializable {

    private String imgUrl;

    private String appKey;


    private Long userId;

    private String type;
}
