package com.kxg.middleground.provider.dao;

import com.kxg.middleground.provider.mapper.KxgProductBlackListMapper;
import com.kxg.middleground.provider.pojo.KxgProduct;
import com.kxg.middleground.provider.pojo.KxgProductBlackList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/3/31 15:34
 * @Description: 项目黑名单
 */
@Repository
public class KxgProductBlackListDao {
    @Autowired
    private KxgProductBlackListMapper blackListMapper;

    public Integer addBlackProduct(KxgProductBlackList kxgProduct){
        return blackListMapper.insert(kxgProduct);
    }

    /**
     * 档前项目是否在黑名单中
     * @param appKey
     * @return
     */
    public Boolean thisProductIsInBlackList(String appKey){
        Example example=new Example(KxgProductBlackList.class);
        example.createCriteria()
                .andEqualTo("appKey",appKey);
        List<KxgProductBlackList> kxgProductBlackLists = blackListMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(kxgProductBlackLists)){
            return false;
        }
        return true;
    }
    /**
     * 删除当前项目在黑名单中的记录
     */
    public Integer deleteThisByAppKey(String appKey){
        Example example=new Example(KxgProductBlackList.class);
        example.createCriteria()
                .andEqualTo("appKey",appKey);
        return blackListMapper.deleteByExample(example);
    }
}
