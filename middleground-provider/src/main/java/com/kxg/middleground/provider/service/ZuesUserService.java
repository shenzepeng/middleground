package com.kxg.middleground.provider.service;

import com.kxg.middleground.request.AddZuesUserRequest;
import com.kxg.middleground.request.FindUserInfoRequest;
import com.kxg.middleground.request.UpdateUserInfoRequest;
import com.kxg.middleground.response.FindOpenIdResponse;
import com.kxg.middleground.response.FindUserInfoResponse;
import com.kxg.middleground.response.IntegerResultResponse;

/**
 * @Auther: szp
 * @Date: 2020/3/31 17:18
 * @Description: 用户系统
 */
public interface ZuesUserService {
    FindOpenIdResponse makeSureThisUserIsExist(String code);
    IntegerResultResponse addUserInfo(AddZuesUserRequest request);
    FindUserInfoResponse findUserInfo(FindUserInfoRequest request);
    IntegerResultResponse updateUserInfo(UpdateUserInfoRequest request);
}
