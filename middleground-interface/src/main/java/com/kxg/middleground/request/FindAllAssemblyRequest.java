package com.kxg.middleground.request;

import lombok.Data;

/**
 * @Auther: szp
 * @Date: 2020/4/20 10:35
 * @Description: 搜索组件
 */
@Data
public class FindAllAssemblyRequest {
    private Integer page=1;
    private Integer size=10;
    private String assemblyName;
}
