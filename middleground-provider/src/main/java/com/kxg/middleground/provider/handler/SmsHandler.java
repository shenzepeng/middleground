package com.kxg.middleground.provider.handler;

/**
 * @Auther: szp
 * @Date: 2020/3/31 18:51
 * @Description: 沈泽鹏写点注释吧
 */
public interface SmsHandler {
    void sendCode(String code,String phoneNumber);
    String getCode();
}
