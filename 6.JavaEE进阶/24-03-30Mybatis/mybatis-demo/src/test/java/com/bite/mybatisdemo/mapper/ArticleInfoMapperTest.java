package com.bite.mybatisdemo.mapper;

import com.bite.mybatisdemo.model.ArticleInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ArticleInfoMapperTest {
    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Test
    void selectArticleByID() {
        System.out.println(articleInfoMapper.selectArticleByID(1));
    }

    @Test
    void selectArticleAndUserByID() {
        System.out.println(articleInfoMapper.selectArticleAndUserByID(1));
    }
}