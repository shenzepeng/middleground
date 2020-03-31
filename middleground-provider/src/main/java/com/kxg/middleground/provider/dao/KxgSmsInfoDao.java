package com.kxg.middleground.provider.dao;

import com.kxg.middleground.provider.mapper.KxgSmsInfoMapper;
import com.kxg.middleground.provider.pojo.KxgSmsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/3/31 16:18
 * @Description: 短信信息
 */
@Repository
public class KxgSmsInfoDao {
    @Autowired
    private KxgSmsInfoMapper kxgSmsInfoMapper;

    /**
     * 新增
     * @param kxgSmsInfo
     * @return
     */
    public Integer addSmsInfo(KxgSmsInfo kxgSmsInfo){
        return kxgSmsInfoMapper.insert(kxgSmsInfo);
    }

    /**
     * 更新短信信息
     * @param kxgSmsInfo
     * @return
     */
    public Integer updateSmsInfo(KxgSmsInfo kxgSmsInfo){
        return kxgSmsInfoMapper.updateByPrimaryKeySelective(kxgSmsInfo);
    }

    /**
     * 通过手机号和code码获取验证码
     * @param phoneNumber
     * @param code
     * @return
     */
    public List<KxgSmsInfo> findSmsInfo(String phoneNumber,String code){
        Example example=new Example(KxgSmsInfo.class);
        example.createCriteria()
                .andEqualTo("phoneNumber",phoneNumber)
                .andEqualTo("code",code);
        return kxgSmsInfoMapper.selectByExample(example);
    }

}
