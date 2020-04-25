package com.kxg.middleground.provider.controller;

import com.kxg.middleground.provider.common.SzpJsonResult;
import com.kxg.middleground.provider.service.SmsService;
import com.kxg.middleground.request.SentSmsCodeRequest;
import com.kxg.middleground.request.VerificationSmsCodeRequest;
import com.kxg.middleground.response.IntegerResultResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @ApiOperation("验证短信,1成功，0失败，zues的appkey-4CE8EE38DCED46D2")
    @PostMapping("sent")
    public SzpJsonResult<IntegerResultResponse> verificationSms(@RequestBody SentSmsCodeRequest request){
        return SzpJsonResult.ok(smsService.sentCode(request));
    }
    /**
     * 发送短信
     */
    @ApiOperation("发送短信,1成功，0失败")
    @PostMapping("ver")
    public SzpJsonResult<IntegerResultResponse> sendSmsCode(@RequestBody VerificationSmsCodeRequest request){
        return SzpJsonResult.ok(smsService.verification(request));
    }


}
