package com.loa.system.oasystem.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 德鲁伊数据源
 */
@Configuration
public class DruidConfig {

    /**
     * 默认数据源
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DruidDataSource druidDataSource(){
        return new DruidDataSource();
    }


}
