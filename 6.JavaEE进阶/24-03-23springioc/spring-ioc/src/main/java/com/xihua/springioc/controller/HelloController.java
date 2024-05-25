package com.xihua.springioc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
    public void sayHi() {
        System.out.println("hello, userController");
    }
}
