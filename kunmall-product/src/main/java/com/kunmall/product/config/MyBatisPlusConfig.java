package com.kunmall.product.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.github.pagehelper.PageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Mybatis-Plus 与 PageHelper混用冲突问题
 * TODO 理解源码
 */
@Configuration
public class MyBatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean
    PageInterceptor pageInterceptor(){
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }
}
