package com.kxg.middleground.provider.dao;

import com.kxg.middleground.provider.mapper.KxgAssemblyProductShipMapper;
import com.kxg.middleground.provider.pojo.KxgAssembly;
import com.kxg.middleground.provider.pojo.KxgAssemblyProductShip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class KxgAssemblyProductShipDao {
    @Autowired
    private KxgAssemblyProductShipMapper shipMapper;

    /**
     * 添加接入关系
     * @param kxgAssemblyProductShip
     * @return
     */
    public Integer addShip(KxgAssemblyProductShip kxgAssemblyProductShip){
        return shipMapper.insert(kxgAssemblyProductShip);
    }

    /**
     * 通过项目id找到关系
     * @param productId
     * @return
     */
    public List<KxgAssemblyProductShip> findShipByProductId(Long productId){
        Example example=new Example(KxgAssemblyProductShip.class);
        example.createCriteria()
                .andEqualTo("productId",productId);
        return shipMapper.selectByExample(example);
    }

    /**
     * 通过组件id找到关系
     * @param assemblyId
     * @return
     */
    public List<KxgAssemblyProductShip> findShipByAssemblyId(Long assemblyId){
        Example example=new Example(KxgAssemblyProductShip.class);
        example.createCriteria()
                .andEqualTo("assemblyId",assemblyId);
        return shipMapper.selectByExample(example);
    }

}
