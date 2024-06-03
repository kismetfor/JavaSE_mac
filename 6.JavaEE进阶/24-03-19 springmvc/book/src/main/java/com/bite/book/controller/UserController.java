package com.bite.book.controller;

import com.bite.book.model.UserInfo;
import com.bite.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String login(String userName, String password, HttpSession session) {
        //1. 校验参数
        //2. 校验密码是否正确
        //3 返回响应结果
        if (!StringUtils.hasLength(userName) ||
        !StringUtils.hasLength(password)) {
            return "用户名或者密码为空";
        }

        //根据账号查询是否有这个人的信息 没有就说明用户不存在
        UserInfo userInfo = userService.getUserByName(userName);
        if (userInfo==null) {
            return "用户不存在";
        }

        //如果有的话查询密码
        if (!password.equals(userInfo.getPassword())) {
            return "密码错误";
        }

        session.setAttribute("userName", userName);
        return "";
    }
}
