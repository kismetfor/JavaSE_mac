package com.bite.book;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/login")
    public String login(String userName, String password, HttpSession session) {
        //1. 校验参数
        //2. 校验密码是否正确
        //3 返回响应结果
        if (!StringUtils.hasLength(userName) ||
        !StringUtils.hasLength(password)) {
            return "用户名或者密码为空";
        }
//        if ("admin".equals(userName) && "admin".equals(password)) {
//            return "账号或者密码错误";
//        }
        if (!"admin".equals(userName) || !"admin".equals(password)) {
            return "账号或者密码错误";
        }
        session.setAttribute("userName", userName);
        return "";
    }
}
