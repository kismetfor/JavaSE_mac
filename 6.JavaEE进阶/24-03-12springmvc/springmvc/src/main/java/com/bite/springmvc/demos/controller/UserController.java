package com.bite.springmvc.demos.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/login")
    public boolean login(String userName, String password, HttpSession session) {
        //参数校验 -- 直接使用方法
//        if (userName==null || userName.length()==0 ||)
        if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
            return false;
        }
        if ("admin".equals(userName) && "admin".equals(password)) {
            //设置session
            session.setAttribute("userName", userName);
            return true;
        }
        return false;
    }
    @RequestMapping("/index")
    public String getUserName(@SessionAttribute("userName") String userName) {
        if (userName == null) {
            return "未登录";
        }
        return "成功登录 用户名: " + userName;
    }

}
