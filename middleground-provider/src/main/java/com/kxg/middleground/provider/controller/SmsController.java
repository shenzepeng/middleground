package com.kxg.middleground.provider.controller;

import com.kxg.middleground.provider.common.SzpJsonResult;
import com.kxg.middleground.provider.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: szp
 * @Date: 2020/3/31 18:48
 * @Description: 沈泽鹏写点注释吧
 */
@RestController
@RequestMapping("sms")
public class SmsController {
    @Autowired
    private SmsService smsService;
    /**
     * 验证短信
     */
    public SzpJsonResult<Boolean> verificationSms(){
        return null;
    }
    /**
     * 发送短信
     */
    public SzpJsonResult<Boolean> sendSmsCode(){
        return null;
    }


}
