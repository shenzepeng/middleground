package com.kxg.middleground.provider.dao;

import com.kxg.middleground.provider.mapper.KxgZuesUserMapper;
import com.kxg.middleground.provider.pojo.KxgProduct;
import com.kxg.middleground.provider.pojo.KxgZuesUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/3/31 16:31
 * @Description: 用户注册
 */
@Repository
public class KxgZuseUserDao {
    @Autowired
    private KxgZuesUserMapper zuesUserMapper;

    /**
     * 添加用户
     * @param kxgZuesUser
     * @return
     */
    public Integer addUser(KxgZuesUser kxgZuesUser){
        return zuesUserMapper.insert(kxgZuesUser);
    }

    /**
     * 通过openid找到信息
     * @param openId
     * @return
     */
    public List<KxgZuesUser> findUserByOpenId(String openId){
        Example example=new Example(KxgZuesUser.class);
        example.createCriteria()
                .andEqualTo("openId",openId);
        return zuesUserMapper.selectByExample(example);
    }

    /**
     * 通过手机号找到信息
     * @param phoneNumber
     * @return
     */
    public List<KxgZuesUser> findUserByPhoneNumber(String phoneNumber){
        Example example=new Example(KxgZuesUser.class);
        example.createCriteria()
                .andEqualTo("phoneNumber",phoneNumber);
        return zuesUserMapper.selectByExample(example);
    }

    /**
     * 通过主键id查找
     * @param id
     * @return
     */
    public KxgZuesUser findZuesById(Long id){
        return zuesUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过主键更新
     * @param zuesUser
     * @return
     */
    public Integer updateUserInfo(KxgZuesUser zuesUser){
        return zuesUserMapper.updateByPrimaryKeySelective(zuesUser);
    }
}
