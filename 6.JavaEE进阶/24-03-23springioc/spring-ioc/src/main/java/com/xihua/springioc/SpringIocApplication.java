package com.xihua.springioc;

import com.xihua.springioc.component.UserComponent;
import com.xihua.springioc.config.BeanConfig;
import com.xihua.springioc.config.UserConfig;
import com.xihua.springioc.controller.HelloController;
import com.xihua.springioc.controller.UController;
import com.xihua.springioc.model.UserInfo;
import com.xihua.springioc.repo.UserRepo;
import com.xihua.springioc.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import static java.beans.Introspector.decapitalize;
@SpringBootApplication
public class SpringIocApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringIocApplication.class, args);
//        HelloController bean1 = context.getBean(HelloController.class);
//
//        bean1.sayHi();
//
//        HelloController bean2 = context.getBean("helloController", HelloController.class);
//        bean2.sayHi();
//
//        HelloController bean3 = (HelloController)context.getBean("helloController");
//        bean3.sayHi();
//        System.out.println(bean1);
//        System.out.println(bean2);
//        System.out.println(bean3);
//
//        UController bean4 = (UController)context.getBean("UController");
//
//        System.out.println(decapitalize("HelloController"));
//        System.out.println(decapitalize("UController"));


//        UserComponent bean = (UserComponent)context.getBean("userComponent");
//        bean.doComponent();
//
//        UserService bean1 = context.getBean(UserService.class);
//        bean1.doService();
//
//        UserConfig bean2 = context.getBean(UserConfig.class);
//        bean2.doConfiguration();
//
//        UserRepo bean3 = context.getBean(UserRepo.class);
//        bean3.doRepository();


//        BeanConfig bean = context.getBean(BeanConfig.class);
//        System.out.println(bean);

        HelloController bean = context.getBean(HelloController.class);
        bean.sayHi();

    }

}
