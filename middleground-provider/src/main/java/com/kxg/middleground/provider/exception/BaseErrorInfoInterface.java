package com.kxg.middleground.provider.exception;

/**
 * @Auther: szp
 * @Date: 2020/4/22 18:01
 * @Description: 沈泽鹏写点注释吧
 */
public interface BaseErrorInfoInterface {
    /** 错误码*/
    String getResultCode();

    /** 错误描述*/
    String getResultMsg();
}
