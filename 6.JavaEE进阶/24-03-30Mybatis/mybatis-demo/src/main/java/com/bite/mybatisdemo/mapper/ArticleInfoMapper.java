package com.bite.mybatisdemo.mapper;

import com.bite.mybatisdemo.model.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleInfoMapper {

    ArticleInfo selectArticleByID(Integer id);
    ArticleInfo selectArticleAndUserByID(Integer id);
}
