package com.bite.generator.mapper;

import com.bite.generator.model.Userinfo;
import java.util.List;

public interface UserinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Userinfo record);

    Userinfo selectByPrimaryKey(Integer id);

    List<Userinfo> selectAll();

    int updateByPrimaryKey(Userinfo record);
}