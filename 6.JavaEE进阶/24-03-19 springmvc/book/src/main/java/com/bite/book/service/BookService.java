package com.bite.book.service;

import com.bite.book.enums.BookStatus;
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
    private BookMapper bookMapper;

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
            bookInfo.setStatusCN(BookStatus.getDescByCode(bookInfo.getStatus()).getDesc());
        }
        return new PageResult<>(bookInfos, count);
    }

    public BookInfo queryBookById(Integer bookId) {
        BookInfo bookInfo = bookMapper.queryBookById(bookId);
        bookInfo.setStatusCN(BookStatus.getDescByCode(bookInfo.getStatus()).getDesc());
        return bookInfo;
    }

    public Integer updateBook(BookInfo bookInfo) {
        return bookMapper.updateBookById(bookInfo);
    }

    public Integer deleteBook(Integer bookID) {
        BookInfo bookInfo = new BookInfo();
        bookInfo.setId(bookID);
        bookInfo.setStatus(0);
        return bookMapper.updateBookById(bookInfo);
    }
}
