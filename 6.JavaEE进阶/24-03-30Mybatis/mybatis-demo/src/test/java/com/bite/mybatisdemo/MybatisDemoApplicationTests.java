package com.bite.mybatisdemo;

import com.bite.mybatisdemo.controller.UserController;
import com.bite.mybatisdemo.mapper.UserInfoMapper;
import com.bite.mybatisdemo.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisDemoApplicationTests {

    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    private UserController userController;

    @Test
    void contextLoads() {
        List<UserInfo> userInfos = userInfoMapper.getUserInfoAll();
        System.out.println(userInfos.toString());
        System.out.println(userController.getUserAll());
    }

}
