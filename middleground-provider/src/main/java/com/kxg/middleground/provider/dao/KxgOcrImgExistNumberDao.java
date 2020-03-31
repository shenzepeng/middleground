package com.kxg.middleground.provider.dao;

import com.kxg.middleground.provider.mapper.KxgOcrImgExistNumberMapper;
import com.kxg.middleground.provider.mapper.KxgOcrImgMapper;
import com.kxg.middleground.provider.pojo.KxgOcrImg;
import com.kxg.middleground.provider.pojo.KxgOcrImgExistNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

/**
 * @Auther: szp
 * @Date: 2020/3/31 13:18
 * @Description: 沈泽鹏写点注释吧
 */
@Repository
public class KxgOcrImgExistNumberDao {
    @Autowired
    private KxgOcrImgExistNumberMapper existNumberMapper;

    /**
     * 新增限制，每个限制
     * @param kxgOcrImgExistNumber
     * @return
     */
    public Integer insert(KxgOcrImgExistNumber kxgOcrImgExistNumber){
        return existNumberMapper.insert(kxgOcrImgExistNumber);
    }

    /**
     * 更新限制
     * @param kxgOcrImgExistNumber
     * @return
     */
    public Integer updateLimitInfo(KxgOcrImgExistNumber kxgOcrImgExistNumber){
        return existNumberMapper.updateByPrimaryKeySelective(kxgOcrImgExistNumber);
    }
    /**
     * 通过userId找到限制详情
     */
    public KxgOcrImgExistNumber findLimitInfoById(Long userId){
        if (null==userId){
            return null;
        }
        Example example=new Example(KxgOcrImgExistNumber.class);
        example.createCriteria()
                .andEqualTo("userId",userId);
        return existNumberMapper.selectOneByExample(userId);
    }

}
