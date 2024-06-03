package com.bite.book.mapper;

import com.bite.book.model.BookInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookMapperTest {
    @Autowired
    private BookMapper bookMapper;
    @Test
    void insert() {
        BookInfo bookInfo = new BookInfo();
        bookInfo.setStatus(1);
        bookInfo.setBookName("活着");
        bookInfo.setAuthor("余华");
        bookInfo.setCount(12);
        bookInfo.setPublish("北京十月文艺出版社");
        bookInfo.setPrice(new BigDecimal("123.12"));
        bookMapper.insert(bookInfo);
    }
}