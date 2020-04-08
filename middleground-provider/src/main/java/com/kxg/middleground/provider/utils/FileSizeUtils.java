package com.kxg.middleground.provider.utils;

import java.math.BigDecimal;

/**
 * @Auther: szp
 * @Date: 2020/4/8 10:49
 * @Description: 文件尺寸工具类
 */
public class FileSizeUtils {
    /**
     * 获取文件大小
     * @param fileSize
     * @return
     */
    public static Double getMbSize(Long fileSize){
        return new BigDecimal(fileSize/1024/1024).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
