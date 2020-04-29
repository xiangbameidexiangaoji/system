package com.loa.system.oasystem.config;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * @author 李涵林
 * @data 2020/4/10 16:56
 */
@Configuration
public class ShiroConfig {
    /**
     * 创建自定义 userRealm
     *
     * @return
     */
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    /**
     * 创建安全管理器
     *
     * @return
     */
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(UserRealm userRealm) {
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        //关联 Realm
        defaultSecurityManager.setRealm(userRealm);
        return defaultSecurityManager;
    }

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultSecurityManager getDefaultSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(getDefaultSecurityManager);

        /**
         * 过滤类型
         *  anon 无需认证
         *  autch 必须认证才可以访问
         *  user 如果使用 RemeberMe 的功能可以直接访问
         *  perms 该资源必须得到资源权限才可以访问
         *  role 该资源必须得到角色权限才可以访问
         */
        LinkedHashMap shiroMap = new LinkedHashMap();
//        shiroMap.put("/**", "autch");
        shiroMap.put("/swagger-ui.html", "anon");
        shiroMap.put("/swagger-resources/**", "anon");
        shiroMap.put("/v2/api-docs", "anon");
        shiroMap.put("/webjars/springfox-swagger-ui/**", "anon");
        shiroMap.put("/user/login", "anon");
        shiroMap.put("/static/**", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(shiroMap);
        //登录页面
//        shiroFilterFactoryBean.setLoginUrl("/user/login");
        return shiroFilterFactoryBean;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager getDefaultSecurityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(getDefaultSecurityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
