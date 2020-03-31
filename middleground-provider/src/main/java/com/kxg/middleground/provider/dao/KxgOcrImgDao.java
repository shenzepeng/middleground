package com.kxg.middleground.provider.dao;

import com.kxg.middleground.provider.mapper.KxgOcrImgMapper;
import com.kxg.middleground.provider.pojo.KxgOcrImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * @Auther: szp
 * @Date: 2020/3/31 13:02
 * @Description: 沈泽鹏写点注释吧
 */
@Repository
public class KxgOcrImgDao {
    @Autowired
    private KxgOcrImgMapper kxgOcrImgMapper;

    /**
     * 添加图像识别
     * @param kxgOcrImg
     * @return
     */
    public Integer addKxgOcrImg(KxgOcrImg kxgOcrImg){
        return kxgOcrImgMapper.insert(kxgOcrImg);
    }

    /**
     * 通过usrid看他一共识别了多少张图
     * @param userId
     * @return
     */
    public Integer countOcrImgByUserId(Long userId){
        Example example=new Example(KxgOcrImg.class);
        example.createCriteria()
                .andEqualTo("userId",userId);
        example.orderBy("id").desc();
        return kxgOcrImgMapper.selectCountByExample(example);
    }
    /**
     * 通过appkey看这个项目一共识别了多少张图
     */
    public Integer countOcrImgByAppKey(String appKey){
        Example example=new Example(KxgOcrImg.class);
        example.createCriteria()
                .andEqualTo("appKey",appKey);
        return kxgOcrImgMapper.selectCountByExample(example);
    }

    /**
     * 通过userid查看文件识别记录
     * @param userId
     * @return
     */
    public List<KxgOcrImg> findOcrImgByUserId(Long userId){
        Example example=new Example(KxgOcrImg.class);
        example.createCriteria()
                .andEqualTo("userId",userId);
        example.orderBy("id").desc();
        return kxgOcrImgMapper.selectByExample(example);
    }
    /**
     * 通过项目名称看他识别记录
     */
    public List<KxgOcrImg> findOcrImgByAppKey(String appKey){
        Example example=new Example(KxgOcrImg.class);
        example.createCriteria()
                .andEqualTo("appKey",appKey);
        example.orderBy("id").desc();
        return kxgOcrImgMapper.selectByExample(example);
    }
}
