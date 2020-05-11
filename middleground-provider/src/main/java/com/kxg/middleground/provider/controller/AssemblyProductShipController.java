package com.kxg.middleground.provider.controller;

import com.kxg.middleground.provider.common.SzpJsonResult;
import com.kxg.middleground.provider.service.AssemblyProductShipService;
import com.kxg.middleground.request.AddAssProductShipRequest;
import com.kxg.middleground.request.FindCanAddAssemblyProductByUserIdRequest;
import com.kxg.middleground.response.FindCanAddAssemblyProductResponse;
import com.kxg.middleground.response.IntegerResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 组件关系
 */
@Api("组件关系")
@RestController
@RequestMapping("ship")
public class AssemblyProductShipController {
    @Autowired
    private AssemblyProductShipService assemblyProductShipService;

    /**
     * 添加组件关系
     * @return
     */
    @ApiOperation("添加组件关系")
    @PostMapping("add/list")
    public SzpJsonResult<IntegerResultResponse> addShip(@RequestBody AddAssProductShipRequest request){
        return SzpJsonResult.ok(assemblyProductShipService.addAssemblyProductShip(request));
    }
    /**
     * 拿到该项目还能添加的组件
     */
    @ApiOperation("拿到该项目还能添加的组件")
    @PostMapping("can/add/product")
    public SzpJsonResult<FindCanAddAssemblyProductResponse> findCanAddAssembly(@RequestBody FindCanAddAssemblyProductByUserIdRequest request){
        return SzpJsonResult.ok(assemblyProductShipService.findCanAddAssemblyByUserId(request));
    }
}
