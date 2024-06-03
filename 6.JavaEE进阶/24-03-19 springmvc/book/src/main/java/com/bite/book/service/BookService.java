package com.bite.book.service;

import com.bite.book.dao.BookDao;
import com.bite.book.mapper.BookMapper;
import com.bite.book.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class BookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BookMapper bookMapper;
    public List<BookInfo> getBookList() {

        List<BookInfo> bookInfos = bookDao.mockData();
        for (BookInfo bookInfo:bookInfos) {
            if (bookInfo.getStatus()==1) {
                bookInfo.setStatusCN("可借阅");
            } else {
                bookInfo.setStatusCN("不可借阅");
            }
        }
        return bookInfos;
    }

    public Integer insertBook(BookInfo bookInfo) {
        return bookMapper.insert(bookInfo);
    }
}
