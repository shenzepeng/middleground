package com.kxg.middleground.provider.dao;

import com.kxg.middleground.provider.mapper.KxgAssemblyMapper;
import com.kxg.middleground.provider.pojo.KxgAssembly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

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

    /**
     * 显示所有组件
     * @return
     */
    public List<KxgAssembly> findAllKxgAssembly(){
        return kxgAssemblyMapper.selectAll();
    }

    /**
     * 通过名称搜索组件
     * @param name
     * @return
     */
    public List<KxgAssembly> findKxgAssemblyByNameLike(String name){
        Example example=new Example(KxgAssembly.class);
        example.createCriteria()
                .andEqualTo("assemblyName","%"+name+"%");
        return kxgAssemblyMapper.selectByExample(example);
    }

    /**
     * 添加组件
     * @param kxgAssembly
     * @return
     */
    public Integer addAssembly(KxgAssembly kxgAssembly){
        return kxgAssemblyMapper.insert(kxgAssembly);
    }

    /**
     * 更新组件信息
     */
    public Integer updateAssemblyInfo(KxgAssembly kxgAssembly){
        return kxgAssemblyMapper.updateByPrimaryKeySelective(kxgAssembly);
    }
}
