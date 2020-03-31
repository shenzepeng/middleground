package com.kxg.middleground.provider.model;

import lombok.Data;

/**
 * @Auther: szp
 * @Date: 2020/3/31 18:19
 * @Description: 沈泽鹏写点注释吧
 */
@Data
public class WXSessionModel {
    private String session_key;
    private String openid;
}
