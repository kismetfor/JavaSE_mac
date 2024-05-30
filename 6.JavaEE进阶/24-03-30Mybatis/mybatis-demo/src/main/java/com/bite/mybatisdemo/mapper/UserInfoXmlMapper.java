package com.bite.mybatisdemo.mapper;

import com.bite.mybatisdemo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoXmlMapper {
    Integer insert(UserInfo userInfo);
    Integer delete(Integer id);
    Integer update(String password);
    List<UserInfo> selectAllUsers();
    List<UserInfo> selectAllUsers2();
    Integer selectCount();
}
