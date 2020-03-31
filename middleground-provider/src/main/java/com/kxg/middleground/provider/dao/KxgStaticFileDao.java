package com.kxg.middleground.provider.dao;

import com.kxg.middleground.provider.mapper.KxgStaticFileDbMapper;
import com.kxg.middleground.provider.pojo.KxgStaticFileDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Auther: szp
 * @Date: 2020/3/31 16:28
 * @Description: 静态文件
 */
@Repository
public class KxgStaticFileDao {
    @Autowired
    private KxgStaticFileDbMapper kxgStaticFileDbMapper;

    /**
     * 新增文件
     * @param fileDb
     * @return
     */
    public Integer addKxgStaticFile(KxgStaticFileDb fileDb){
        return kxgStaticFileDbMapper.insert(fileDb);
    }
}
