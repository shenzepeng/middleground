package com.kxg.middleground.provider.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kxg.middleground.dto.ProductDto;
import com.kxg.middleground.provider.dao.KxgProductDao;
import com.kxg.middleground.provider.pojo.KxgProduct;
import com.kxg.middleground.provider.service.ProductService;
import com.kxg.middleground.provider.utils.Md5Util;
import com.kxg.middleground.request.AddProductRequest;
import com.kxg.middleground.request.FindAllMyProductByOpenIdRequest;
import com.kxg.middleground.request.FindAllMyProductByUserIdRequest;
import com.kxg.middleground.response.FindMyProductInfoResponse;
import com.kxg.middleground.response.FindProductInfoResponse;
import com.kxg.middleground.response.IntegerResultResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/4/20 13:47
 * @Description: 项目
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private KxgProductDao kxgProductDao;

    @Override
    public IntegerResultResponse addProduct(AddProductRequest addProductRequest) {
        IntegerResultResponse resultResponse=new IntegerResultResponse();
        KxgProduct kxgProduct=new KxgProduct();
        BeanUtils.copyProperties(addProductRequest,kxgProduct);
        kxgProduct.setCreateTime(new Date());
        kxgProduct.setUpdateTime(new Date());
        kxgProduct.setAppKey(Md5Util.getKey());
        Integer result = kxgProductDao.addProduct(kxgProduct);
        resultResponse.setResult(result);
        return resultResponse;
    }

    @Override
    public FindMyProductInfoResponse findProductByUserId(FindAllMyProductByUserIdRequest request) {
        FindMyProductInfoResponse response=new FindMyProductInfoResponse();
        PageHelper.startPage(request.getPage(),request.getSize());
        List<ProductDto> productDtos=new ArrayList<>();
        if (!StringUtils.isEmpty(request.getProductName())){
            List<KxgProduct> productByUserId = kxgProductDao.findProductByUserIdAndProductName(request.getUserId(),request.getProductName());
            PageInfo<KxgProduct> productPageInfo=new PageInfo<>(productByUserId);
            for (KxgProduct kxgProduct : productPageInfo.getList()) {
                ProductDto productDto= new ProductDto();
                BeanUtils.copyProperties(kxgProduct,productDto);
                productDtos.add(productDto);
            }
            response.setProductDtos(productDtos);
            response.setTotal(productPageInfo.getTotal());
            return response;
        }
        List<KxgProduct> productByUserId = kxgProductDao.findProductByUserId(request.getUserId());
        PageInfo<KxgProduct> productPageInfo=new PageInfo<>(productByUserId);
        for (KxgProduct kxgProduct : productPageInfo.getList()) {
            ProductDto productDto= new ProductDto();
            BeanUtils.copyProperties(kxgProduct,productDto);
            productDtos.add(productDto);
        }
        response.setProductDtos(productDtos);
        response.setTotal(productPageInfo.getTotal());
        return response;
    }

    @Override
    public FindMyProductInfoResponse findProductByOpenId(FindAllMyProductByOpenIdRequest request) {
        FindMyProductInfoResponse response=new FindMyProductInfoResponse();
        PageHelper.startPage(request.getPage(),request.getSize());
        List<ProductDto> productDtos=new ArrayList<>();
        if (!StringUtils.isEmpty(request.getProductName())){
            List<KxgProduct> productByUserId = kxgProductDao.findProductByOpenidAndProductName(request.getOpenId(),request.getProductName());
            PageInfo<KxgProduct> productPageInfo=new PageInfo<>(productByUserId);
            for (KxgProduct kxgProduct : productPageInfo.getList()) {
                ProductDto productDto= new ProductDto();
                BeanUtils.copyProperties(kxgProduct,productDto);
                productDtos.add(productDto);
            }
            response.setProductDtos(productDtos);
            response.setTotal(productPageInfo.getTotal());
            return response;
        }
        List<KxgProduct> productByUserId = kxgProductDao.findProductByOpenId(request.getOpenId());
        PageInfo<KxgProduct> productPageInfo=new PageInfo<>(productByUserId);
        for (KxgProduct kxgProduct : productPageInfo.getList()) {
            ProductDto productDto= new ProductDto();
            BeanUtils.copyProperties(kxgProduct,productDto);
            productDtos.add(productDto);
        }
        response.setProductDtos(productDtos);
        response.setTotal(productPageInfo.getTotal());
        return response;
    }

    @Override
    public FindProductInfoResponse findProductInfoByProductId(Long productId) {
        FindProductInfoResponse response=new FindProductInfoResponse();
        KxgProduct productById = kxgProductDao.findProductById(productId);
        BeanUtils.copyProperties(productById,response);
        return response;
    }
}
