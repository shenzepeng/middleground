package com.kxg.middleground.provider.controller;

import com.kxg.middleground.provider.common.SzpJsonResult;
import com.kxg.middleground.provider.service.ZuesUserService;
import com.kxg.middleground.request.AddZuesUserRequest;
import com.kxg.middleground.request.UpdateUserInfoRequest;
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
    @GetMapping("make/sure/user/is/exist")
    public SzpJsonResult<Boolean> makeSureUserIsExist(String code){
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
    @PostMapping("add/user/info")
    public SzpJsonResult<?> addUserInfo(@RequestBody AddZuesUserRequest addZuesUserRequest){
        return SzpJsonResult.ok(zuesUserService.addUserInfo(addZuesUserRequest));
    }

    /**
     * 更新用户信息
     * @param request
     * @return
     */
    @PutMapping("update/user/info")
    public SzpJsonResult<?> updateUserInfo(@RequestBody UpdateUserInfoRequest request){
        return SzpJsonResult.ok();
    }


}
