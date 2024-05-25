package com.xihua.springioc.config;

import com.xihua.springioc.model.UserInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public UserInfo userInfo() {
        return new UserInfo("zhangsan");
    }
    @Bean
    public UserInfo userInfo1() {
        return new UserInfo("zhangsan1");
    }
}
