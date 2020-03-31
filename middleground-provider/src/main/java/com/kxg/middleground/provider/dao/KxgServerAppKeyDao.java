package com.kxg.middleground.provider.dao;

import com.kxg.middleground.provider.mapper.KxgServerAppKeyMapper;
import com.kxg.middleground.provider.pojo.KxgServerAppKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/3/31 16:05
 * @Description: 项目唯一的key
 */
@Repository
public class KxgServerAppKeyDao {
    @Autowired
    private KxgServerAppKeyMapper serverAppKeyMapper;

    /**
     * 当前appkey存不存在
     * 不存在返回false
     * 存在返回true
     * @param appKey
     * @return
     */
    public Boolean findAppKeyIsExist(String appKey){
        Example example=new Example(KxgServerAppKey.class);
        example.createCriteria()
                .andEqualTo("appKey",appKey);
        List<KxgServerAppKey> kxgServerAppKeys = serverAppKeyMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(kxgServerAppKeys)){
            return false;
        }
        return true;
    }

    /**
     * 添加appkey
     * @param kxgServerAppKey
     * @return
     */
    public Integer addKey(KxgServerAppKey kxgServerAppKey){
        return serverAppKeyMapper.insert(kxgServerAppKey);
    }


}
