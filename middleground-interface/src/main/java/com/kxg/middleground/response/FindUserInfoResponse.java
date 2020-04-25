package com.kxg.middleground.response;

import com.kxg.middleground.dto.ZuesUserInfoDto;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: szp
 * @Date: 2020/4/24 20:39
 * @Description: 沈泽鹏写点注释吧
 */
@Data
public class FindUserInfoResponse  {

    private Long id;


    private String phoneNumber;

    private String password;

    private Short type;


    private Date createTime;


    private Date updateTime;

    private String requestId;

    private String headerUrl;


    private String nickName;


    private String openId;
}
