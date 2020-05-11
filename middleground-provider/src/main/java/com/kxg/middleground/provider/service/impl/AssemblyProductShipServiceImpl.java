package com.kxg.middleground.provider.service.impl;

import com.kxg.middleground.dto.CanAddProductDto;
import com.kxg.middleground.provider.dao.KxgAssemblyProductShipDao;
import com.kxg.middleground.provider.dao.KxgProductDao;
import com.kxg.middleground.provider.pojo.KxgAssemblyProductShip;
import com.kxg.middleground.provider.pojo.KxgProduct;
import com.kxg.middleground.provider.service.AssemblyProductShipService;
import com.kxg.middleground.request.AddAssProductShipRequest;
import com.kxg.middleground.request.FindCanAddAssemblyProductByUserIdRequest;
import com.kxg.middleground.response.FindCanAddAssemblyProductResponse;
import com.kxg.middleground.response.IntegerResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AssemblyProductShipServiceImpl implements AssemblyProductShipService {
    @Autowired
    private KxgAssemblyProductShipDao assemblyProductShipDao;
    @Autowired
    private KxgProductDao kxgProductDao;
    /**
     * 添加关系
     * @param
     * @return
     */
    @Override
    public IntegerResultResponse addAssemblyProductShip(AddAssProductShipRequest request) {
        if (CollectionUtils.isEmpty(request.getProductIds())){
            throw new RuntimeException("product ids can not be null");
        }
        IntegerResultResponse integerResultResponse=new IntegerResultResponse();

        List<KxgAssemblyProductShip> needAddShip=new ArrayList<>();
        List<Long> productIds = request.getProductIds();
        for (Long productId : productIds) {
            KxgAssemblyProductShip assemblyProductShip=new KxgAssemblyProductShip();
            BeanUtils.copyProperties(request,assemblyProductShip);
            assemblyProductShip.setCreateTime(new Date());
            assemblyProductShip.setUpdateTime(new Date());
            assemblyProductShip.setProductId(productId);
            needAddShip.add(assemblyProductShip);
        }
        log.info("add assembly and product ship {}",needAddShip);
        Integer result = assemblyProductShipDao.addShipList(needAddShip);
        integerResultResponse.setResult(result);
        return integerResultResponse;
    }

    @Override
    public FindCanAddAssemblyProductResponse findCanAddAssemblyByUserId(FindCanAddAssemblyProductByUserIdRequest request) {
        FindCanAddAssemblyProductResponse response=new FindCanAddAssemblyProductResponse();
        //所有的项目
        List<KxgProduct> productByUserId = kxgProductDao.findProductByUserId(request.getUserId());
        //用户的所有项目
        Map<Long, KxgProduct> userProducts = productByUserId.stream().collect(Collectors.toMap(KxgProduct::getId, kxgProduct -> kxgProduct));
        //接入该组件的所有项目
        List<KxgAssemblyProductShip> shipByAssemblyId = assemblyProductShipDao.findShipByAssemblyId(request.getAssemblyId());
        //所有添加的该组件的项目id
        List<Long> hasAddProductIds = shipByAssemblyId.stream().map(t -> t.getProductId()).collect(Collectors.toList());
        //用户所有的项目
        Set<Long> ids = userProducts.keySet();
        //所有可以添加组件的项目
        List<Long> canAddAssemblyProductIds=new ArrayList<>();
        for (Long id : ids) {
            if (!hasAddProductIds.contains(id)){
                canAddAssemblyProductIds.add(id);
            }
        }
        List<CanAddProductDto> canAddProductDtos=new ArrayList<>();
        for (Long canAddAssemblyProductId : canAddAssemblyProductIds) {
            CanAddProductDto canAddProductDto=new CanAddProductDto();
            KxgProduct kxgProduct = userProducts.get(canAddAssemblyProductId);
            canAddProductDto.setProductId(canAddAssemblyProductId);
            canAddProductDto.setProductName(kxgProduct.getProductName());
            canAddProductDtos.add(canAddProductDto);
        }
        response.setList(canAddProductDtos);
        return response;
    }
}
