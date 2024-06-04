package com.bite.book.controller;

import com.bite.book.model.BookInfo;
import com.bite.book.model.PageRequest;
import com.bite.book.model.PageResult;
import com.bite.book.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequestMapping("/book")
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    /**
     * 添加图书
     * 使用 @RequestBody 注解将请求体中的 JSON 数据映射为 BookInfo 对象。
     */
    @RequestMapping("/addBook")
    private String addBook(BookInfo bookInfo) {
        //校验参数
        log.info("添加图书, 接收到参数: bookInfo {}", bookInfo);
        if (!StringUtils.hasLength(bookInfo.getBookName())
                || !StringUtils.hasLength(bookInfo.getAuthor())
                || bookInfo.getCount() == null
                || bookInfo.getPrice() == null
                || bookInfo.getStatus() == null
                || !StringUtils.hasLength(bookInfo.getPublish())) {
            return "输入参数不合法";
        }
        try {
            //添加图书
            Integer result = bookService.insertBook(bookInfo);
            if (result > 0) {
                return "";
            }
        } catch (Exception e) {
            log.info("捕捉异常信息 e: ", e);
        }

        return "添加失败";
    }

    /**
     * 查询图书列表
     */
    @RequestMapping("/getBookListByPage")
    public PageResult<BookInfo> getBookListByPage(PageRequest pageRequest) {
        log.info("查询图书列表 pageRequest: {}", pageRequest);
        return bookService.getBookListByPage(pageRequest);
    }

    @RequestMapping("/queryBookById")
    public BookInfo queryBookById(Integer bookId) {
        log.info("根据id查询图书信息 id: {}", bookId);
        return bookService.queryBookById(bookId);
    }

    @RequestMapping("/updateBook")
    public String updateBook(BookInfo bookInfo) {
        log.info("更新图书, book: {}", bookInfo);
        try {
            Integer result = bookService.updateBook(bookInfo);
            if (result > 0) return "";
            return "内部错误";
        } catch (Exception e) {
            log.error("发生错误, e: ", e);
            return "更新失败, 请联系管理员";
        }
    }
    @RequestMapping("/deleteBook")
    public String deleteBook(Integer bookID) {
        log.info("删除图书, book: {}", bookID);
        try {
            Integer result = bookService.deleteBook(bookID);
            if (result > 0) return "";
            return "内部错误";
        } catch (Exception e) {
            log.error("发生错误, e: ", e);
            return "删除失败, 请联系管理员";
        }
    }
}
