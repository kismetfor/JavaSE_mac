package com.bite.springioc;

import com.bite.springioc.controller.HelloController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIocApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringIocApplication.class, args);
        HelloController bean = context.getBean(HelloController.class);
        bean.sayHi();
    }

}
