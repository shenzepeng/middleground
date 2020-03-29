package com.kxg.middleground.provider;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

@NacosPropertySource(dataId = "KXG_MIDDLE_GROUP", autoRefreshed = true,groupId = "DEFAULT_GROUP")
@EnableAutoConfiguration
public class DubboProviderBootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DubboProviderBootstrap.class)
                .run(args);
    }
}