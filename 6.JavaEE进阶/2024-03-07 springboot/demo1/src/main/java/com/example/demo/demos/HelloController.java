package com.example.demo.demos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("hello")
    public String hello() {
        int a = 10/0;
        return "hello, spring boot";
    }
}
