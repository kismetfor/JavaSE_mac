package com.bite.book.service;

import com.bite.book.dao.BookDao;
import com.bite.book.mapper.BookMapper;
import com.bite.book.model.BookInfo;
import com.bite.book.model.PageRequest;
import com.bite.book.model.PageResult;
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
    public PageResult<BookInfo> getBookListByPage(PageRequest pageRequest) {
        //1. 获取总记录数
        //2. 获取当前页面的记录
        Integer count = bookMapper.count();
        List<BookInfo> bookInfos = bookMapper.getBookListByPage(pageRequest.getOffset(), pageRequest.getPageSize());

        //3. 处理状态
        //4. 状态 0-删除 1-可借阅 2-不可借阅
        for (BookInfo bookInfo:
                bookInfos) {
            if (bookInfo.getStatus() == 1) {
                bookInfo.setStatusCN("可借阅");
            } else if (bookInfo.getStatus() == 0) {
                bookInfo.setStatusCN("已删除");
            } else {
                bookInfo.setStatusCN("不可借阅");
            }
        }
        return new PageResult<>(bookInfos, count);
    }
}
