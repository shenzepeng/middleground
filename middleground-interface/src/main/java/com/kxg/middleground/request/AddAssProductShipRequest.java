package com.kxg.middleground.request;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/4/20 11:21
 * @Description: 沈泽鹏写点注释吧
 */
@Data
public class AddAssProductShipRequest {

    private Long assemblyId;


    private List<Long> productIds;

    private String createUser;
}
