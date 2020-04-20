package com.kxg.middleground.response;

import com.kxg.middleground.dto.CanAddProductDto;
import lombok.Data;

import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/4/20 12:52
 * @Description: 获取可以添加组件的id
 */
@Data
public class FindCanAddAssemblyProductResponse {
   private List<CanAddProductDto> list;
}
