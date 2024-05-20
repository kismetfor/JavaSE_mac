package com.bite.springmvc.demos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/calc")
@RestController
public class CalcController {
    //路径 : <form action="calc/sum"
    @RequestMapping("/sum")
    public String sum(Integer num1, Integer num2) {
        Integer sum = num2 + num1;
        return "计算器计算结果: " + sum;
    }
}
