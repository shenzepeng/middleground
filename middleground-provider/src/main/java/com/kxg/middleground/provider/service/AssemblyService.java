package com.kxg.middleground.provider.service;

import com.kxg.middleground.request.FindAllAssemblyRequest;
import com.kxg.middleground.response.FindAllAssemblyResponse;
import com.kxg.middleground.response.FindAssemblyByIdResponse;

public interface AssemblyService {
    FindAllAssemblyResponse findAssembly(FindAllAssemblyRequest request);
    FindAssemblyByIdResponse findAssemblyById(Long assemblyId);
}
