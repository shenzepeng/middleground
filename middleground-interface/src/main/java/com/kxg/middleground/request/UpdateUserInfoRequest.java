package com.kxg.middleground.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class UpdateUserInfoRequest implements Serializable {
    private String phoneNumber;

    private String password;

    private Short type;

    private String headerUrl;

    private String nickName;

    private String openId;

}
