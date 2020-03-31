package com.kxg.middleground.provider.handler.impl;

import com.kxg.middleground.provider.handler.SmsHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Auther: szp
 * @Date: 2020/3/31 18:52
 * @Description: 沈泽鹏写点注释吧
 */
@Slf4j
@Component
public class SmsHandlerImpl implements SmsHandler {
    @Override
    public void sendCode(String code, String phoneNumber) {

    }

    @Override
    public String getCode() {
        return (int)(Math.random()*9999)+100+"";
    }
}
