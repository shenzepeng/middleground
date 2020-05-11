package com.kxg.middleground.provider.service;

import com.kxg.middleground.request.AddProductRequest;

import com.kxg.middleground.request.FindAllMyProductByOpenIdRequest;
import com.kxg.middleground.request.FindAllMyProductByUserIdRequest;
import com.kxg.middleground.response.FindMyProductInfoResponse;
import com.kxg.middleground.response.FindProductHasAddAssemblyInfoResponse;
import com.kxg.middleground.response.FindProductInfoResponse;
import com.kxg.middleground.response.IntegerResultResponse;

/**
 * @Auther: szp
 * @Date: 2020/4/20 13:47
 * @Description: 项目
 */
public interface ProductService {
    IntegerResultResponse addProduct(AddProductRequest addProductRequest);
    FindMyProductInfoResponse findProductByUserId(FindAllMyProductByUserIdRequest request);
    FindMyProductInfoResponse findProductByOpenId(FindAllMyProductByOpenIdRequest request);
    FindProductInfoResponse findProductInfoByProductId(Long productId);
    FindProductHasAddAssemblyInfoResponse findHasAddAssemblyInfo(Long productId);
}
