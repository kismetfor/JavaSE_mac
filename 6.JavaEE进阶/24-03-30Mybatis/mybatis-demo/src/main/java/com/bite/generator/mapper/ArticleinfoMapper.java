package com.bite.generator.mapper;

import com.bite.generator.model.Articleinfo;
import java.util.List;

public interface ArticleinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Articleinfo record);

    Articleinfo selectByPrimaryKey(Integer id);

    List<Articleinfo> selectAll();

    int updateByPrimaryKey(Articleinfo record);
}