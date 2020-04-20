package com.kxg.middleground.request;

import lombok.Data;

/**
 * @Auther: szp
 * @Date: 2020/4/20 15:37
 * @Description: 沈泽鹏写点注释吧
 */
@Data
public class FindAllMyProductByUserIdRequest {
    private String productName;
    private Long userId;
    private Integer page;
    private Integer size;
}
