package com.kxg.middleground.provider.service;

import com.kxg.middleground.request.OcrImgToStringRequest;
import com.kxg.middleground.response.StringResultResponse;

/**
 * @Auther: szp
 * @Date: 2020/4/8 17:21
 * @Description: 图片识别
 */
public interface OcrService {
    StringResultResponse getOcr(OcrImgToStringRequest request,String ip);
}
