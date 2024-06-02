package com.bite.springmvc.demos.mapper;

import com.bite.springmvc.demos.model.MessageInfo;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@MapperScan("com.bite.springmvc.demos.mapper")
class MessageInfoMapperTest {
    @Autowired
    private MessageInfoMapper messageInfoMapper;
    @Test
    void insertMessage() {
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setFrom("徐涛");
        messageInfo.setTo("张雨潇");
        messageInfo.setSay("fuck me");
        messageInfoMapper.insertMessage(messageInfo);
    }

    @Test
    void selectAllMessage() {
        System.out.println(messageInfoMapper.selectAllMessage());
    }
}