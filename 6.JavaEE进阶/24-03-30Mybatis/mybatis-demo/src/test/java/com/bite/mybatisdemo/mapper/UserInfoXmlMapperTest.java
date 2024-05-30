package com.bite.mybatisdemo.mapper;

import com.bite.mybatisdemo.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserInfoXmlMapperTest {

    @Autowired
    private UserInfoXmlMapper userInfoXmlMapper;
    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("张雨潇");
        userInfo.setPassword("120012");
        userInfo.setAge(5);
        userInfo.setGender(1);
        System.out.println(userInfoXmlMapper.insert(userInfo));
    }

    @Test
    void delete() {
        System.out.println(userInfoXmlMapper.delete(12));
    }

    @Test
    void update() {
        System.out.println(userInfoXmlMapper.update("1233"));
    }

    @Test
    void selectAllUsers() {
        System.out.println(userInfoXmlMapper.selectAllUsers());
    }

    @Test
    void selectCount() {
        System.out.println("=========" + userInfoXmlMapper.selectCount());
    }

    @Test
    void selectAllUsers2() {
        System.out.println("========" + userInfoXmlMapper.selectAllUsers2());
    }
}