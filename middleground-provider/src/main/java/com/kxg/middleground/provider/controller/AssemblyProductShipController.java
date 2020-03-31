package com.kxg.middleground.provider.controller;

import com.kxg.middleground.provider.common.SzpJsonResult;
import com.kxg.middleground.provider.service.AssemblyProductShipService;
import com.kxg.middleground.provider.service.AssemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 组件关系
 */
@RestController
public class AssemblyProductShipController {
    @Autowired
    private AssemblyProductShipService assemblyProductShipService;

    /**
     * 添加组件
     * @return
     */
    public SzpJsonResult<?> addShip(){
        return SzpJsonResult.ok();
    }
}
