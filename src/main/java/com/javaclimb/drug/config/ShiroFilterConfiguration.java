package com.javaclimb.drug.config;
import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 权限控制Shiro配置类
 */
@Configuration
public class ShiroFilterConfiguration {
    /**
     * 创建过滤工厂Bean
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        /**
         * Shiro内置过滤器，实现权限相关的拦截器
         * anon: 无需登陆，可以访问
         * authc: 必须登陆才可以访问
         */

        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/static/**","anon");  //设置不需要权限的
        filterMap.put("/login","anon");
        filterMap.put("/toLogin","anon");
        filterMap.put("/**","authc");   //必须登陆才可以访问

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        shiroFilterFactoryBean.setLoginUrl("/login");  //不登陆会自动跳转的页面
        shiroFilterFactoryBean.setSuccessUrl("/index");  //登陆后自动跳转的页面
        return shiroFilterFactoryBean;
    }

    /**
     * 权限管理
     */
    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        return securityManager;
    }

    /**
     * 创建Realm,认证用
     * @return
     */
    @Bean
    public UserRealm userRealm(){
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }

    /**
     * thymeleaf 整合 Shiro
     */
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}
