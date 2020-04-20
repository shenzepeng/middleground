package com.kxg.middleground.response;

import com.kxg.middleground.dto.ZuesAssemblyDto;
import lombok.Data;

import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/4/20 10:33
 * @Description: 组件包装类
 */
@Data
public class FindAllAssemblyResponse {
    private List<ZuesAssemblyDto> assemblyDtos;
    private Long total;
}
