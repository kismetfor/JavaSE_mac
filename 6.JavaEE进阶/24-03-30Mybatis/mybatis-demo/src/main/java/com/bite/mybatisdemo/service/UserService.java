package com.bite.mybatisdemo.service;

import com.bite.mybatisdemo.mapper.UserInfoMapper;
import com.bite.mybatisdemo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    public List<UserInfo> getUserAll() {
        return userInfoMapper.getUserInfoAll();
    }
}
