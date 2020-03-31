package com.kxg.middleground.provider.handler;

/**
 * @Auther: szp
 * @Date: 2020/3/31 18:18
 * @Description: 沈泽鹏写点注释吧
 */

public interface WxChatHandler {
    /**
     * 通过微信传来的code码获取
     * 用户的openId
     * @param code
     * @return
     */
    String getWxChatOpenIdHandler(String code);
}
