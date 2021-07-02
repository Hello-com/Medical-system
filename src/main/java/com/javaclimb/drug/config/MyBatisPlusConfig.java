package com.javaclimb.drug.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatisPlus配置类
 */
@Configuration  //优先加载我们的@Configuration,把系统的覆盖掉
@MapperScan(value = "com.javaclimb.drug.mapper")  //扫描那个包，当作我们的mapper
public class MyBatisPlusConfig {
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");  //对哪一个语言的翻译
        return page;

    }
}
