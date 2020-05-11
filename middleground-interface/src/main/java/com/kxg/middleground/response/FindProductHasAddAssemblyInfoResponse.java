package com.kxg.middleground.response;

import com.kxg.middleground.dto.AssemblyDto;
import com.kxg.middleground.dto.ProductDto;
import lombok.Data;

import java.util.List;

/**
 * 要写注释呀
 */
@Data
public class FindProductHasAddAssemblyInfoResponse {
    private ProductDto productDto;
    private List<AssemblyDto> assemblyDtos;
}
