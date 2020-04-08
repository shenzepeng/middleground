package com.kxg.middleground.provider.service.impl;

import com.kxg.middleground.provider.dao.KxgZuseUserDao;
import com.kxg.middleground.provider.handler.WxChatHandler;
import com.kxg.middleground.provider.pojo.KxgZuesUser;
import com.kxg.middleground.provider.service.ZuesUserService;
import com.kxg.middleground.request.AddZuesUserRequest;
import com.kxg.middleground.response.IntegerResultResponse;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/3/31 18:31
 * @Description: 沈泽鹏写点注释吧
 */
@Data
public class ZuesUserServiceImpl implements ZuesUserService {
    @Autowired
    private KxgZuseUserDao kxgZuseUserDao;
    @Autowired
    private WxChatHandler wxChatHandler;
    @Override
    public IntegerResultResponse makeSureThisUserIsExist(String code) {
        IntegerResultResponse resultResponse=new IntegerResultResponse();
        String openId = wxChatHandler.getWxChatOpenIdHandler(code);
        if (StringUtils.isEmpty(openId)){
            //没有拿到openId服务异常
        }
        List<KxgZuesUser> userByOpenId = kxgZuseUserDao.findUserByOpenId(openId);
        //当前openID不存在则
        if (CollectionUtils.isEmpty(userByOpenId)){
            resultResponse.setResult(1);
        }
        resultResponse.setResult(0);
        return resultResponse;
    }

    /**
     * 添加用户信息
     * @param request
     * @return
     */
    @Override
    public IntegerResultResponse addUserInfo(AddZuesUserRequest request) {
        IntegerResultResponse resultResponse=new IntegerResultResponse();
        KxgZuesUser kxgZuesUser=new KxgZuesUser();
        BeanUtils.copyProperties(request,kxgZuesUser);
        kxgZuesUser.setCreateTime(new Date());
        kxgZuesUser.setCreateTime(new Date());
        Integer result = kxgZuseUserDao.addUser(kxgZuesUser);
        resultResponse.setResult(result);
        return resultResponse;
    }
}
