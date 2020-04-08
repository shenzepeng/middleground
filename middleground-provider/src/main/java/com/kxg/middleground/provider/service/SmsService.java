package com.kxg.middleground.provider.service;

import com.kxg.middleground.request.SentSmsCodeRequest;
import com.kxg.middleground.request.VerificationSmsCodeRequest;
import com.kxg.middleground.response.IntegerResultResponse;

/**
 * @Auther: szp
 * @Date: 2020/3/31 18:48
 * @Description: 短信发送业务逻辑
 */

public interface SmsService {
    IntegerResultResponse sentCode(SentSmsCodeRequest request);
    IntegerResultResponse verification(VerificationSmsCodeRequest request);
}
