package com.bite.mybatisdemo.mapper;

import com.bite.mybatisdemo.model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserInfoMapper {
    @ResultMap("resultMap")
    @Select("select * from userinfo")
    List<UserInfo> selectUserInfo();

    @Select("select * from userinfo")
    List<UserInfo> getUserInfoAll();

    @Select("select * from userinfo where delete_flag = #{deleteFlag}")
    List<UserInfo> getUserInfo1(Integer flag);

    @Select("select * from userinfo where delete_flag = #{deleteFlag} and gender = #{gender}")
    List<UserInfo> getUserInfo2(@Param("deleteFlag") Integer flag, @Param("gender") Integer gender);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT into userinfo (username, password, age, gender) values (#{username}, #{password}, #{age}, #{gender})")
    Integer insert(UserInfo userInfo);

    @Insert("INSERT into userinfo (username, password, age, gender) values" +
            " (#{userInfo.username}, #{userInfo.password}, #{userInfo.age}, #{userInfo.gender})")
    Integer insert2(@Param("userInfo") UserInfo userInfo);

    @Delete("DELETE from userinfo where id = #{id}")
    Integer delete(Integer id);

    @Update("update userinfo set password = #{password}, age = #{age}, gender = #{gender} where id = #{id}")
    Integer update(UserInfo userInfo);

    /**
     * 起别名
     *
     * @return  List<UserInfo>
     */
    @Select("SELECT id, username, `password`, age, gender, phone, delete_flag AS deleteFlag, " +
            "create_time AS createTime, update_time AS updateTime FROM userinfo;")
    List<UserInfo> selectUserInfos();

    @Results(id = "resultMap", value = {
            @Result(column = "delete_flag", property = "deleteFlag"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime"),
    })
    @Select("SELECT * from userinfo")
    List<UserInfo> selectUserInfo2();


    @Select("SELECT * from userinfo")
    List<UserInfo> selectUserInfo3();
    @Select("select * from userinfo where username = #{username}")
    UserInfo getUserByName(String username);

    @Select("select * from userinfo where username = '${username}'")
    List<UserInfo> getUserByName2(String username);

    @Select("select * from userinfo where id = #{id}")
    UserInfo getUserByID(Integer id);

    @Select("select * from userinfo where id = ${id}")
    UserInfo getUserByID2(Integer id);



}
