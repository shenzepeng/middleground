package com.kxg.middleground.provider.dao;

import com.kxg.middleground.provider.mapper.KxgAssemblyMapper;
import com.kxg.middleground.provider.pojo.KxgAssembly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/3/24 13:58
 * @Description: 组件dao
 */
@Repository
public class KxgAssemblyDao {
    @Autowired
    private KxgAssemblyMapper kxgAssemblyMapper;

    public List<KxgAssembly> findAllKxgAssembly(){
        return kxgAssemblyMapper.selectAll();
    }


}
