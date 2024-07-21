package com.example.java_gobang.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    //插入一个用户, 用于注册功能
    void insert(User user);
    //根据用户名, 来查询用户的详细信息, 用于登录
    User selectByName(String username);
    // 总比赛场数 + 1, 获胜场数 + 1, 天梯分数 + 30
    void userWin(int userId);

    // 总比赛场数 + 1, 获胜场数 不变, 天梯分数 - 30
    void userLose(int userId);
}
