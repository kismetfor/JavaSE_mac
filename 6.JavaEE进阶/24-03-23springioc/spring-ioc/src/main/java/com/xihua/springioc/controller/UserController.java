package com.xihua.springioc.controller;

import com.xihua.springioc.model.UserInfo;
import com.xihua.springioc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("usercon")
public class UserController {
//    @Qualifier("userInfo1")
    @Resource(name = "userInfo")
    @Autowired
    private UserInfo user;
    public void sayHi(){
        System.out.println("hi, UserController");
    }

}
