package com.kxg.middleground.provider.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Auther: szp
 * @Date: 2019/11/25 15:20
 * @Description: 沈泽鹏写点注释吧
 */
public interface CommonMapper<T> extends Mapper<T>, MySqlMapper<T> {
}