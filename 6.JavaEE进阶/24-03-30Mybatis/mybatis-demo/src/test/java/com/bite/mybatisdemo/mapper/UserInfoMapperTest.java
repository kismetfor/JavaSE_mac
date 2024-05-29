package com.bite.mybatisdemo.mapper;

import com.bite.mybatisdemo.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void getUserInfoAll() {
    }

    @Test
    void getUserInfo1() {
    }

    @Test
    void testGetUserInfo1() {
//        List<UserInfo> userInfos = userInfoMapper.getUserInfo1(0);
//        System.out.println(userInfos);
        System.out.println(userInfoMapper.getUserInfo1(0));
    }


    @Test
    void testGetUserInfo2() {
        System.out.println(userInfoMapper.getUserInfo2(0, 1));

    }
}