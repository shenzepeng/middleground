package com.kxg.middleground.provider.handler.impl;

import com.baidu.aip.ocr.AipOcr;
import com.kxg.middleground.provider.handler.OcrHandler;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class OcrHandlerImpl implements OcrHandler {
    //百度AI
    public static final String APP_ID = "11519092";
    public static final String API_KEY = "q3TlGWWqEBG9uGvlFIBtpvY5";
    public static final String SECRET_KEY = "A14W5VRNG8my1GXYYAyNND0RjzBwxI8A";

    @Override
    public String orcImg(String imgUrl) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        // 调用接口
        //进行网络图片的识别
        JSONObject jsonObject = client.generalUrl(imgUrl, null);
        System.out.println(jsonObject.toString());
        //转为jsonObject
        JSONArray jsonArray = jsonObject.getJSONArray("words_result");
        StringBuffer buffer=new StringBuffer();
        jsonArray.forEach(t->{
            buffer.append(t.toString()+"%");
        });
        log.info("图像识别的结果-{}",buffer.toString());
        return buffer.toString();
    }
}
