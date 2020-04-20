package com.kxg.middleground.provider.service;

import com.kxg.middleground.request.AddAssProductShipRequest;

import com.kxg.middleground.request.FindCanAddAssemblyProductByUserIdRequest;
import com.kxg.middleground.response.FindCanAddAssemblyProductResponse;
import com.kxg.middleground.response.IntegerResultResponse;

public interface AssemblyProductShipService {

    IntegerResultResponse addAssemblyProductShip(AddAssProductShipRequest request);
    FindCanAddAssemblyProductResponse findCanAddAssemblyByUserId(FindCanAddAssemblyProductByUserIdRequest request);
}
