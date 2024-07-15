package com.example.java_gobang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.example.java_gobang.model") // 指定Mapper接口所在的包

public class GobangApplication  {
    public static ConfigurableApplicationContext context;
    public static void main(String[] args) {
        context = SpringApplication.run(GobangApplication.class, args);
    }



}
