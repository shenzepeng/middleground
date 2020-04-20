package com.kxg.middleground.request;

import lombok.Data;

/**
 * @Auther: szp
 * @Date: 2020/4/20 10:35
 * @Description: 搜索组件
 */
@Data
public class FindAllAssemblyRequest {
    private Integer page;
    private Integer size;
    private String assemblyName;
}
