package com.kxg.middleground.provider.service.impl;

import com.kxg.middleground.provider.constants.MiddlerGroudConstans;
import com.kxg.middleground.provider.dao.KxgOcrImgDao;
import com.kxg.middleground.provider.handler.OcrHandler;
import com.kxg.middleground.provider.pojo.KxgOcrImg;
import com.kxg.middleground.provider.service.OcrService;
import com.kxg.middleground.request.OcrImgToStringRequest;
import com.kxg.middleground.response.StringResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @Auther: szp
 * @Date: 2020/4/8 17:24
 * @Description: 沈泽鹏写点注释吧
 */
@Slf4j
@Service
public class OcrServiceImpl implements OcrService {
    @Autowired
    private KxgOcrImgDao kxgOcrImgDao;
    @Autowired
    private OcrHandler ocrHandler;
    @Override
    public StringResultResponse getOcr(OcrImgToStringRequest request,String ip) {
        StringResultResponse resultResponse=new StringResultResponse();
        if (StringUtils.isEmpty(request.getType())){
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String content = ocrHandler.orcImg(request.getImgUrl());
        KxgOcrImg kxgOcrImg=new KxgOcrImg();
        kxgOcrImg.setAppKey(request.getAppKey());
        kxgOcrImg.setContent(content);
        kxgOcrImg.setCreateTime(new Date());
        kxgOcrImg.setUpdateTime(new Date());
        kxgOcrImg.setUserId(request.getUserId());
        kxgOcrImg.setReuqestIp(ip);
        kxgOcrImg.setStatus(MiddlerGroudConstans.OCR_IMG_FIRST_SUCCESS);
        kxgOcrImgDao.addKxgOcrImg(kxgOcrImg);
        resultResponse.setResult(content);
        return resultResponse;
    }
}
