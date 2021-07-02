package com.javaclimb.drug.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Controller
public class GoWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    /**
     * 添加静态资源文件，外部可以直接访问地址
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/","classpath:templates/")
                .addResourceLocations("/","classpath:static/");
        super.addResourceHandlers(registry);
    }


}
