package com.kxg.middleground.provider.service.impl;

import com.kxg.middleground.provider.dao.KxgSmsInfoDao;
import com.kxg.middleground.provider.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: szp
 * @Date: 2020/3/31 18:49
 * @Description: 沈泽鹏写点注释吧
 */
@Service
public class SmsServiceImpl implements SmsService {
    @Autowired
    private KxgSmsInfoDao kxgSmsInfoDao;
    @Override
    public void sentCode(String phoneNumber) {

    }

    @Override
    public Boolean verification(String phoneNumber, String code) {
        return null;
    }
}
