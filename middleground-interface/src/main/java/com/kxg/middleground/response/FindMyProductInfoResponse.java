package com.kxg.middleground.response;

import com.kxg.middleground.dto.ProductDto;
import lombok.Data;

import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/4/20 13:44
 * @Description: 沈泽鹏写点注释吧
 */
@Data
public class FindMyProductInfoResponse {
    private List<ProductDto> productDtos;
    private Long total;
}
