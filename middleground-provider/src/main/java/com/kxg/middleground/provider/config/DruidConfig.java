package com.kxg.middleground.provider.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Lists;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.support.http.StatViewServlet;
/**
 * druid的视图配置
 * http://localhost/druid/index.html
 */
@Configuration
public class DruidConfig {
    //这个注解读取配置文件前缀为prefix的配置，将外部的配置文件与这里绑定
    @ConfigurationProperties(prefix = "spring.datasource")
    //容器的开启与关闭
    @Bean(initMethod = "init",destroyMethod = "close")
    public DruidDataSource dataSource(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setProxyFilters(Lists.newArrayList(statFilter()));
        return  dataSource;
    }
    //bean注解，成为spring的bean，利用filter将慢sql的日志打印出来
    @Bean
    public Filter statFilter(){
        StatFilter statFilter=new StatFilter();
        //多长时间定义为慢sql，这里定义为5s
        statFilter.setSlowSqlMillis(5000);
        //是否打印出慢日志
        statFilter.setLogSlowSql(true);
        //是否将日志合并起来
        statFilter.setMergeSql(true);
        return  statFilter;
    }
    //这是配置druid的监控
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
    }
}
