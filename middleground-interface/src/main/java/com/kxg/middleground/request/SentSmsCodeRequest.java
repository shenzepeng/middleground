package com.kxg.middleground.request;

import lombok.Data;

/**
 * @Auther: szp
 * @Date: 2020/4/8 17:39
 * @Description: 沈泽鹏写点注释吧
 */
@Data
public class SentSmsCodeRequest {
    private String phoneNumber;
    private String appKey;
    private Long userId;
}
