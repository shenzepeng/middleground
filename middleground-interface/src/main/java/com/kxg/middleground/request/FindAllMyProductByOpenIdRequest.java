package com.kxg.middleground.request;

import lombok.Data;

/**
 * @Auther: szp
 * @Date: 2020/4/20 15:37
 * @Description: 沈泽鹏写点注释吧
 */
@Data
public class FindAllMyProductByOpenIdRequest {
    private String productName;
    private String openId;
    private Integer page;
    private Integer size;
}
