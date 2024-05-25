package com.xihua.springioc.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    public void doConfiguration() {
        System.out.println("do Configuration");
    }
}
