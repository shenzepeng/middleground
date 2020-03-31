package com.kxg.middleground.provider.service.impl;

import com.kxg.middleground.provider.dao.KxgAssemblyProductShipDao;
import com.kxg.middleground.provider.pojo.KxgAssemblyProductShip;
import com.kxg.middleground.provider.service.AssemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssemblyProductShipServiceImpl implements AssemblyService {
    @Autowired
    private KxgAssemblyProductShipDao assemblyProductShipDao;

    /**
     * 添加关系
     * @param kxgAssemblyProductShip
     * @return
     */
    public Integer addShip(KxgAssemblyProductShip kxgAssemblyProductShip){
        return assemblyProductShipDao.addShip(kxgAssemblyProductShip);
    }


}
