package com.bite.book.controller;

import com.bite.book.model.BookInfo;
import com.bite.book.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@RequestMapping("/book")
@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping("/getBookList")
    public List<BookInfo> getBook() {
//        BookService bookService = new BookService();
        return bookService.getBookList();
    }
    /**
     * 添加图书
     * 使用 @RequestBody 注解将请求体中的 JSON 数据映射为 BookInfo 对象。
     */
    @RequestMapping("/addBook")
    private String addBook(BookInfo bookInfo) {
        //校验参数
        log.info("添加图书, 接收到参数: bookInfo {}", bookInfo);
        if (!StringUtils.hasLength(bookInfo.getBookName())
                ||!StringUtils.hasLength(bookInfo.getAuthor())
                ||bookInfo.getCount() == null
                ||bookInfo.getPrice() == null
                ||bookInfo.getStatus() == null
                ||!StringUtils.hasLength(bookInfo.getPublish())) {
            return "输入参数不合法";
        }
        try {
            //添加图书
            Integer result = bookService.insertBook(bookInfo);
            if (result > 0) {
                return "";
            }
        } catch (Exception e) {
            log.info("捕捉异常信息 e: " , e);
        }

        return "添加失败";
    }
}
