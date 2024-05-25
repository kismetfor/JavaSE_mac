package com.xihua.springioc.controller;

import com.xihua.springioc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
    @Autowired
    private UserService userService;
    private UController uController;
//    public HelloController() {
//    }
//    @Autowired
//    public HelloController(UserService userService) {
//        this.userService = userService;
//    }
//
//    public HelloController(UserService userService, UController uController) {
//        this.userService = userService;
//        this.uController = uController;
//    }

    //Setter方法注入


//    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void sayHi() {
        userService.doService();

        System.out.println("hello, userController");
    }
}
