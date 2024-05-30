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
    void getUserInfo3() {
        System.out.println(userInfoMapper.getUserInfo2(0, 1));
    }

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("xutao");
        userInfo.setPassword("xutao");
        userInfo.setAge(10);
        userInfo.setGender(1);
        Integer result = userInfoMapper.insert(userInfo);
        System.out.println("result"+ result + " id " + userInfo.getId());
    }

    @Test
    void insert2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("xutao22");
        userInfo.setPassword("xutao222");
        userInfo.setAge(10);
        userInfo.setGender(1);
        Integer result = userInfoMapper.insert2(userInfo);
        System.out.println("result"+ result);
    }

    @Test
    void delete() {
        System.out.println(userInfoMapper.delete(5));
    }

    @Test
    void update() {
        UserInfo userInfo = new UserInfo();
        userInfo.setPassword("123456");
        userInfo.setAge(99);
        userInfo.setGender(2);
        userInfo.setId(4);
        Integer result = userInfoMapper.update(userInfo);
        System.out.println("result = " + result);
    }

    @Test
    void selectUserInfos() {
        System.out.println(userInfoMapper.selectUserInfos());
    }

    @Test
    void selectUserInfo2() {
        System.out.println(userInfoMapper.selectUserInfo2());
    }

    @Test
    void selectUserInfo() {
        System.out.println(userInfoMapper.selectUserInfo());
    }

    @Test
    void selectUserInfo3() {
        System.out.println(userInfoMapper.selectUserInfo3());
    }
}