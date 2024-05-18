package com.bite.springmvc.demos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/request")
@RestController
public class RequestController {
    @RequestMapping("/hello")
    public String say() {
        return "hello, spring mvc";
    }
    @RequestMapping("r1")
    public String r1(String name) {
        return "接收到参数, name = " + name;
    }
    @RequestMapping("r2")
    public String r2(Integer age) {
        return "接收到参数, age = " + age;
    }
    @RequestMapping("r3")
    public String r3(int age) {
        return "r3接收到参数, age = " + age;
    }
    @RequestMapping("r4")
    public String r4(String name, Integer age) {
        return "r4接收到参数, name = " + name+
                " , 接收到参数, age = " + age;
    }
}
