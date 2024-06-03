package com.bite.book.mapper;

import com.bite.book.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoMapperTest {

    private static final Logger log = LoggerFactory.getLogger(UserInfoMapperTest.class);

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void getUserByName() {
        UserInfo zhangsan = userInfoMapper.getUserByName("zhangsan");
        System.out.println(zhangsan);
        log.info("查询数据:{}", zhangsan);
    }
}
