package com.kxg.middleground.provider.dao;

import com.kxg.middleground.provider.mapper.KxgSmsExistNumberMapper;
import com.kxg.middleground.provider.pojo.KxgSmsExistNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/3/31 16:12
 * @Description: 沈泽鹏写点注释吧
 */
@Repository
public class KxgSmsExistNumberDao {
    @Autowired
    private KxgSmsExistNumberMapper smsExistNumberMapper;

    /**
     * 通过添加短信限制次数
     * @param kxgSmsExistNumber
     * @return
     */
    public Integer addSmsExistNumber(KxgSmsExistNumber kxgSmsExistNumber){
        return smsExistNumberMapper.insert(kxgSmsExistNumber);
    }

    /**
     * 通过appKey找到当前项目的限制总数
     * @param appKey
     * @return
     */
    public KxgSmsExistNumber findSmsExistNumberByAppKey(String appKey){
        Example example=new Example(KxgSmsExistNumber.class);
        example.createCriteria()
                .andEqualTo("appKey",appKey);
        return smsExistNumberMapper.selectOneByExample(example);
    }
}
