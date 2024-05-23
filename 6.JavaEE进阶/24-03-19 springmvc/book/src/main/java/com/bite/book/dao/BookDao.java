package com.bite.book.dao;

import com.bite.book.model.BookInfo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Component
public class BookDao {
    public List<BookInfo> mockData() {
        List<BookInfo> bookInfos = new ArrayList<>();

        //mock数据
        for (int i = 0; i < 15; i++) {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(i);
            bookInfo.setBookName("图书"+i);
            bookInfo.setAuthor("作者"+i);
            bookInfo.setNum(1+i*2);
            bookInfo.setPrice(new BigDecimal(i*3));
            bookInfo.setPublishName("出版社"+i);
            if (i%5==0) {
                bookInfo.setStatus(2);
//                bookInfo.setStatusCN("可借阅");
            } else {
                bookInfo.setStatus(1);
//                bookInfo.setStatusCN("不可借阅");
            }
            bookInfos.add(bookInfo);
        }
        return bookInfos;
    }
}
