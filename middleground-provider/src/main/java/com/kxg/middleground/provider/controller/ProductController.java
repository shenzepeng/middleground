package com.kxg.middleground.provider.controller;

import com.kxg.middleground.provider.common.SzpJsonResult;
import com.kxg.middleground.provider.service.ProductService;
import com.kxg.middleground.request.AddProductRequest;
import com.kxg.middleground.request.FindAllMyProductByOpenIdRequest;
import com.kxg.middleground.request.FindAllMyProductByUserIdRequest;
import com.kxg.middleground.response.FindAllProductByUserIdResponse;
import com.kxg.middleground.response.FindMyProductInfoResponse;
import com.kxg.middleground.response.FindProductInfoResponse;
import com.kxg.middleground.response.IntegerResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("项目")
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;
    /**
     * 查看我的项目列表
     */
    @ApiOperation("查看我的项目列表")
    @GetMapping("user/id/list")
    public SzpJsonResult<FindMyProductInfoResponse> findMyProductList(@RequestBody FindAllMyProductByUserIdRequest request){
        return SzpJsonResult.ok(productService.findProductByUserId(request));
    }

    /**
     * 通过openid查看
     * @param
     * @return
     */
    @ApiOperation("通过openid查看")
    @GetMapping("openid/list")
    public SzpJsonResult<FindMyProductInfoResponse> findMyProductListByOpenId(@RequestBody FindAllMyProductByOpenIdRequest request){
        return SzpJsonResult.ok(productService.findProductByOpenId(request));
    }
    /**
     * 查看项目信息
     */
    @ApiOperation("查看项目信息")
    @GetMapping("info/id")
    public SzpJsonResult<FindProductInfoResponse> findProductById(Long productId){
        return SzpJsonResult.ok(productService.findProductInfoByProductId(productId));
    }
    /**
     * 添加项目
     */
    @ApiOperation("添加项目")
    @PostMapping
    public SzpJsonResult<IntegerResultResponse> addProduct(AddProductRequest request){
        return SzpJsonResult.ok(productService.addProduct(request));
    }
}
