package com.kxg.middleground.provider.dao;

import com.kxg.middleground.provider.mapper.KxgImgFileDbMapper;
import com.kxg.middleground.provider.pojo.KxgImgFileDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

/**
 * @Auther: szp
 * @Date: 2020/3/31 12:46
 * @Description: 图片dao
 */
@Repository
public class KxgImgFileDbDao {
    @Autowired
    private KxgImgFileDbMapper kxgImgFileDbMapper;

    public Integer addImgFile(KxgImgFileDb kxgImgFileDb){
        return kxgImgFileDbMapper.insert(kxgImgFileDb);
    }

    /**
     * 查询有多少个图片总共
     * @return
     */
    public Integer countNumbers(){
        Example example=new Example(KxgImgFileDb.class);
        example.createCriteria()
                .andIsNotNull("id");
        return kxgImgFileDbMapper.selectCountByExample(example);
    }
    /**
     * 查询当前用户上传了多少张图
     */
    public Integer countNumbersByUserIds(Long userId){
        if (null==userId){
            return 0;
        }
        Example example=new Example(KxgImgFileDb.class);
        example.createCriteria()
                .andEqualTo("userId",userId);
        return kxgImgFileDbMapper.selectCountByExample(example);
    }
    /**
     * 查看当前项目上传了多张图
     */
    public Integer countNumbersByAppKey(String appKey){
        if (StringUtils.isEmpty(appKey)){
            return 0;
        }
        Example example=new Example(KxgImgFileDb.class);
        example.createCriteria()
                .andEqualTo("appKey",appKey);
        return kxgImgFileDbMapper.selectCountByExample(example);
    }
}
