package com.kxg.middleground.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author mac
 * @Auther: szp
 * @Date: 2020/3/31 17:21
 * @Description: 沈泽鹏写点注释吧
 */
@Data
public class AddZuesUserRequest implements Serializable {
    private String phoneNumber;
    private String openId;
    private String password;
    private String headerUrl;
    private String nickName;
}
