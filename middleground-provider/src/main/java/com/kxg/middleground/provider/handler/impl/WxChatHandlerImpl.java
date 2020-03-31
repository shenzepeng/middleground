package com.kxg.middleground.provider.handler.impl;

import com.kxg.middleground.provider.handler.WxChatHandler;
import com.kxg.middleground.provider.model.WXSessionModel;
import com.kxg.middleground.provider.utils.HttpClientUtil;
import com.kxg.middleground.provider.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: szp
 * @Date: 2020/3/31 18:22
 * @Description: 沈泽鹏写点注释吧
 */
@Slf4j
@Component
public class WxChatHandlerImpl implements WxChatHandler {
    /**
     * 获取微信openId流程
     * @param code
     * @return
     */
    @Override
    public String getWxChatOpenIdHandler(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> param = new HashMap<>();
        //小程序id
        param.put("appid", "wxe5e476c440a56df3");
        //微信秘钥
        param.put("secret", "c21f05d89c84af53d1fc8675467b1bf7");
        param.put("js_code", code);
        //写死
        param.put("grant_type", "authorization_code");
        String wxResult = HttpClientUtil.doGet(url, param);
        log.info("获取档期的结果,微信信息-{}",wxResult);
        WXSessionModel model = JsonUtils.jsonToPojo(wxResult, WXSessionModel.class);
        return  model.getOpenid();
    }
}
