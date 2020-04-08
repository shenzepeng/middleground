package com.kxg.middleground.request;

import lombok.Data;

/**
 * @Auther: szp
 * @Date: 2020/4/8 17:41
 * @Description: 沈泽鹏写点注释吧
 */
@Data
public class VerificationSmsCodeRequest {
    private String code;
    private String phoneNumber;
}
