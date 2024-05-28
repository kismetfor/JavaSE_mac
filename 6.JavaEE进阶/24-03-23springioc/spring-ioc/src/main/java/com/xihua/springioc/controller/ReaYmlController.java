package com.xihua.springioc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/yml")
public class ReaYmlController {

    @Value("${server.port}")
    private String key;
//
    @Value("${mykey}")
    private String mykey;

//    @Value("${mykey1_key1}")
//    private String key1;

    @RequestMapping("/readyml")
    public String readYml() {
//        return "从yml中获取: " + key + ", " + key1;
        return "从yml中获取: " + key + ", " + mykey;
    }
}