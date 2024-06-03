package com.bite.book.dao;

import com.bite.book.model.BookInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Repository
@Component
public class BookDao {
//    @Value("${book.pages.num}")
//    private Integer num;
    public List<BookInfo> mockData() {
        List<BookInfo> bookInfos = new ArrayList<>();

        //mock数据
        for (int i = 0; i < 10; i++) {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(i);
            bookInfo.setBookName("图书"+i);
            bookInfo.setAuthor("作者"+i);
            bookInfo.setPrice(new BigDecimal(i*3));
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
