package com.bite.mybatisdemo.mapper;

import com.bite.mybatisdemo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserInfoMapper {
    @Select("select * from userinfo")
    List<UserInfo> getUserInfoAll();

    @Select("select * from userinfo where delete_flag = #{deleteFlag}")
    List<UserInfo> getUserInfo1(Integer flag);

    @Select("select * from userinfo where delete_flag = #{deleteFlag} and gender = #{gender}")
    List<UserInfo> getUserInfo2(@Param("deleteFlag") Integer flag, @Param("gender") Integer gender);


}
