package com.kxg.middleground.provider.service.impl;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.kxg.middleground.provider.constants.MiddlerGroudConstans;
import com.kxg.middleground.provider.dao.KxgSmsInfoDao;
import com.kxg.middleground.provider.handler.SmsHandler;
import com.kxg.middleground.provider.pojo.KxgSmsInfo;
import com.kxg.middleground.provider.service.SmsService;
import com.kxg.middleground.request.SentSmsCodeRequest;
import com.kxg.middleground.request.VerificationSmsCodeRequest;
import com.kxg.middleground.response.IntegerResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/3/31 18:49
 * @Description: 沈泽鹏写点注释吧
 */
@Service
public class SmsServiceImpl implements SmsService {
    @Autowired
    private KxgSmsInfoDao kxgSmsInfoDao;
    @Autowired
    private SmsHandler smsHandler;

    @Override
    public IntegerResultResponse sentCode(SentSmsCodeRequest request) {
        IntegerResultResponse resultResponse=new IntegerResultResponse();
        String code = smsHandler.getCode();
        SendSmsResponse sendSmsResponse = smsHandler.sendCode(request.getPhoneNumber(), code);
        KxgSmsInfo smsInfo=new KxgSmsInfo();
        smsInfo.setAppKey(request.getAppKey());
        smsInfo.setBizId(sendSmsResponse.getBizId());
        smsInfo.setPhoneNumber(request.getPhoneNumber());
        smsInfo.setContent(code);
        smsInfo.setCreateTime(new Date());
        smsInfo.setUpdateTime(new Date());
        smsInfo.setMaxVerifyTimes(MiddlerGroudConstans.MAX_VERIFY_TIMES);
        smsInfo.setRequestId(sendSmsResponse.getRequestId());
        smsInfo.setStatus(MiddlerGroudConstans.SMS_NOT_VERIFY_PASS);
        smsInfo.setUserId(request.getUserId());
        Integer reuslt = kxgSmsInfoDao.addSmsInfo(smsInfo);
        resultResponse.setResult(reuslt);
        return resultResponse;
    }

    @Override
    public IntegerResultResponse verification(VerificationSmsCodeRequest request) {
        IntegerResultResponse resultResponse=new IntegerResultResponse();
        List<KxgSmsInfo> smsInfoByPhoneNumber = kxgSmsInfoDao.findSmsInfoByPhoneNumber(request.getPhoneNumber());
        if (CollectionUtils.isEmpty(smsInfoByPhoneNumber)){
            throw new RuntimeException("当前手机号没有记录，请检查手机号是否正确");
        }
        KxgSmsInfo smsInfo = smsInfoByPhoneNumber.get(0);
        if (smsInfo.getContent().equals(request.getCode())){
            smsInfo.setStatus(MiddlerGroudConstans.SMS_VERIFY_PASS);
            smsInfo.setUpdateTime(new Date());
        }
        Integer result = kxgSmsInfoDao.updateSmsInfo(smsInfo);
        resultResponse.setResult(result);
        return resultResponse;
    }
}
