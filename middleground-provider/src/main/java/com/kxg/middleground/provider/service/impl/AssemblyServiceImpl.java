package com.kxg.middleground.provider.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kxg.middleground.dto.ZuesAssemblyDto;
import com.kxg.middleground.provider.dao.KxgAssemblyDao;
import com.kxg.middleground.provider.pojo.KxgAssembly;
import com.kxg.middleground.provider.service.AssemblyService;
import com.kxg.middleground.request.FindAllAssemblyRequest;
import com.kxg.middleground.response.FindAllAssemblyResponse;
import com.kxg.middleground.response.FindAssemblyByIdResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AssemblyServiceImpl implements AssemblyService {
    @Autowired
    private KxgAssemblyDao kxgAssemblyDao;

    /**
     * 搜索组件信息
     * @param request
     * @return
     */
    @Override
    public FindAllAssemblyResponse findAssembly(FindAllAssemblyRequest request) {
        FindAllAssemblyResponse response=new FindAllAssemblyResponse();
        PageHelper.startPage(request.getPage(),request.getSize());
        if (StringUtils.isEmpty(request.getAssemblyName())){

            List<KxgAssembly> allKxgAssembly = kxgAssemblyDao.findAllKxgAssembly();
            PageInfo<KxgAssembly> pageInfo = new PageInfo<>(allKxgAssembly);
            response.setAssemblyDtos( getAssmeblyDtoFromKxgAssembly(pageInfo.getList()));
            response.setTotal(pageInfo.getTotal());
            return response;
        }
        List<KxgAssembly> allKxgAssembly = kxgAssemblyDao.findKxgAssemblyByNameLike(request.getAssemblyName());
        PageInfo<KxgAssembly> pageInfo = new PageInfo<>(allKxgAssembly);
        response.setAssemblyDtos( getAssmeblyDtoFromKxgAssembly(pageInfo.getList()));
        response.setTotal(pageInfo.getTotal());
        return response;
    }

    @Override
    public FindAssemblyByIdResponse findAssemblyById(Long assemblyId) {
        FindAssemblyByIdResponse response=new FindAssemblyByIdResponse();
        KxgAssembly assemblyById = kxgAssemblyDao.findAssemblyById(assemblyId);
        BeanUtils.copyProperties(assemblyById,response);
        return response;
    }

    /**
     * 将组件信息转化为dto
     * @param allKxgAssembly
     * @return
     */
    private List<ZuesAssemblyDto> getAssmeblyDtoFromKxgAssembly( List<KxgAssembly> allKxgAssembly){
        List<ZuesAssemblyDto> zuesAssemblyDtos=new ArrayList<>();
        for (KxgAssembly kxgAssembly : allKxgAssembly) {
            ZuesAssemblyDto zuesAssemblyDto=new ZuesAssemblyDto();
            BeanUtils.copyProperties(kxgAssembly,zuesAssemblyDto);
            zuesAssemblyDtos.add(zuesAssemblyDto);
        }
        return zuesAssemblyDtos;
    }
}
