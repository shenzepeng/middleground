package com.kxg.middleground.provider.handler;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;

/**
 * @Auther: szp
 * @Date: 2020/3/31 18:51
 * @Description: 沈泽鹏写点注释吧
 */
public interface SmsHandler {
    SendSmsResponse sendCode(String code, String phoneNumber);
    String getCode();
}
