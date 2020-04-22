package com.kxg.middleground.provider;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@NacosPropertySource(dataId = "KXG_MIDDLE_GROUP", autoRefreshed = true,groupId = "DEFAULT_GROUP")
@EnableSwagger2
@SpringBootApplication
public class DubboProviderBootstrap extends SpringBootServletInitializer {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DubboProviderBootstrap.class)
                .run(args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DubboProviderBootstrap.class);
    }

}