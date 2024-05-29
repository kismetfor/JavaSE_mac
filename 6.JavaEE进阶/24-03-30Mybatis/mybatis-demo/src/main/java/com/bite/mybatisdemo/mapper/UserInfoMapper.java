package com.bite.mybatisdemo.mapper;

import com.bite.mybatisdemo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserInfoMapper {
    @Select("select * from userinfo")
    List<UserInfo> getUserInfoAll();



}
