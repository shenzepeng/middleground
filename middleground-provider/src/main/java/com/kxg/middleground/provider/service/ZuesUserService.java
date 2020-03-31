package com.kxg.middleground.provider.service;

import com.kxg.middleground.request.AddZuesUserRequest;

/**
 * @Auther: szp
 * @Date: 2020/3/31 17:18
 * @Description: 用户系统
 */
public interface ZuesUserService {
    Boolean makeSureThisUserIsExist(String code);
    Integer addUserInfo(AddZuesUserRequest request);
}
