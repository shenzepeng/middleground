package com.kxg.middleground.request;

import lombok.Data;

/**
 * @Auther: szp
 * @Date: 2020/4/24 20:41
 * @Description: 沈泽鹏写点注释吧
 */
@Data
public class FindUserInfoRequest {
    private Long id;
    private String openId;
    private String phoneNumber;
}
