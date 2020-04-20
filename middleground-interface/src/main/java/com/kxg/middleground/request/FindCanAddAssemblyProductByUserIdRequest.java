package com.kxg.middleground.request;

import lombok.Data;

/**
 * @Auther: szp
 * @Date: 2020/4/20 12:55
 * @Description: 沈泽鹏写点注释吧
 */
@Data
public class FindCanAddAssemblyProductByUserIdRequest {
    private Long userId;
    private Long assemblyId;
}
