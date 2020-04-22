package com.kxg.middleground.provider.controller;

import com.kxg.middleground.provider.common.SzpJsonResult;
import com.kxg.middleground.provider.service.AssemblyService;
import com.kxg.middleground.request.FindAllAssemblyRequest;
import com.kxg.middleground.request.UpdateAssemblyRequest;
import com.kxg.middleground.response.FindAllAssemblyResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 组件信息
 */
@Api("组件信息")
@RestController
@RequestMapping("assembly")
public class AssemblyController {
    @Autowired
    private AssemblyService assemblyService;
    /**
     * 添加组件
     */

    /**
     * 查看组件列表
     */
    @ApiOperation("查看组件列表")
    @PostMapping("search")
    public SzpJsonResult<FindAllAssemblyResponse>  findAllAssembly(@RequestBody FindAllAssemblyRequest request){
        return SzpJsonResult.ok(assemblyService);
    }
    /**
     * 更新组件
     */

    public SzpJsonResult<?> updateAssembly(@RequestBody UpdateAssemblyRequest request){
        return SzpJsonResult.ok();
    }

}
