package com.xihua.springioc.config;

import com.xihua.springioc.model.UserInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfig {

    @Primary
    @Bean
    public UserInfo userInfo() {
        return new UserInfo("zhangsan");
    }
    @Bean
    public UserInfo userInfo1() {
        return new UserInfo("zhangsan1");
    }
}
