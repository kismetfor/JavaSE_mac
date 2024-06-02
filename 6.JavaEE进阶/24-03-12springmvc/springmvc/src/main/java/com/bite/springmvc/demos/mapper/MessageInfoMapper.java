package com.bite.springmvc.demos.mapper;

import com.bite.springmvc.demos.model.MessageInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MessageInfoMapper {
    /**
     * 发布留言
     */

    @Insert("insert into message_info (`from`, `to`, message) VALUES (#{from},#{to},#{say})")
    Integer insertMessage(MessageInfo messageInfo);
    /**
     * 获取留言列表
     */
    @Select("select * from message_info where delete_flag = 0")
    Integer selectAllMessage();

}
