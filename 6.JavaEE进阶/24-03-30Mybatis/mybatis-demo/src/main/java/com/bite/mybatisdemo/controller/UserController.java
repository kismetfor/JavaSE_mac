package com.bite.mybatisdemo.controller;

import com.bite.mybatisdemo.model.UserInfo;
import com.bite.mybatisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("getUserAll")
    public List<UserInfo> getUserAll() {
        return userService.getUserAll();
    }
}
