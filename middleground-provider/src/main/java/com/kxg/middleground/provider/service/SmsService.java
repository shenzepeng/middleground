package com.kxg.middleground.provider.service;

/**
 * @Auther: szp
 * @Date: 2020/3/31 18:48
 * @Description: 短信发送业务逻辑
 */

public interface SmsService {
    void sentCode(String phoneNumber);
    Boolean verification(String phoneNumber,String code);
}
