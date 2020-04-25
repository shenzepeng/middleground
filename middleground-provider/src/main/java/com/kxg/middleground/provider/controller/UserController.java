package com.kxg.middleground.provider.controller;

import com.kxg.middleground.provider.common.SzpJsonResult;
import com.kxg.middleground.provider.service.ZuesUserService;
import com.kxg.middleground.request.AddZuesUserRequest;
import com.kxg.middleground.request.FindUserInfoRequest;
import com.kxg.middleground.request.UpdateUserInfoRequest;
import com.kxg.middleground.response.FindUserInfoResponse;
import com.kxg.middleground.response.IntegerResultResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: szp
 * @Date: 2020/3/31 18:14
 * @Description: 沈泽鹏写点注释吧
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private ZuesUserService zuesUserService;

    /**
     * 当前openId不存在
     * 存在返回ture
     * 不存在返回false
     * @param code
     * @return
     */
    @ApiOperation("通过code看当前openid是否存在,0存在1不存在，不存在走添加逻辑")
    @GetMapping("make/sure/user/is/exist")
    public SzpJsonResult<IntegerResultResponse> makeSureUserIsExist(String code){
        return SzpJsonResult.ok(zuesUserService.makeSureThisUserIsExist(code));
    }

    /**
     * 添加新的用户
     * 微信小程序端
     * 1成功
     * 0失败
     * @param addZuesUserRequest
     * @return
     */
    @ApiOperation("添加新的用户")
    @PostMapping("add/user/info")
    public SzpJsonResult<IntegerResultResponse> addUserInfo(@RequestBody AddZuesUserRequest addZuesUserRequest){
        return SzpJsonResult.ok(zuesUserService.addUserInfo(addZuesUserRequest));
    }

    /**
     * 更新用户信息
     * @param request
     * @return
     */
    @ApiOperation("更新新的用户信息")
    @PutMapping("update/user/info")
    public SzpJsonResult<IntegerResultResponse> updateUserInfo(@RequestBody UpdateUserInfoRequest request){
        return SzpJsonResult.ok();
    }


    @ApiOperation("查看用户信息")
    @PostMapping("find/user/info")
    public SzpJsonResult<FindUserInfoResponse> findUserInfo(@RequestBody FindUserInfoRequest request){
        return SzpJsonResult.ok(zuesUserService.findUserInfo(request));
    }


}
