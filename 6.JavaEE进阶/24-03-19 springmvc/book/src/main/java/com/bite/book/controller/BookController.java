package com.bite.book.controller;

import com.bite.book.constant.Constants;
import com.bite.book.enums.ResultStatus;
import com.bite.book.model.*;
import com.bite.book.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


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
    public Result<PageResult<BookInfo>> getBookListByPage(PageRequest pageRequest, HttpSession session) {
        log.info("查询图书列表 pageRequest: {}", pageRequest);

        UserInfo loginUserInfo = (UserInfo)session.getAttribute(Constants.USER_SESSION_KEY);
        if (loginUserInfo == null || loginUserInfo.getId() < 0) {
            Result result = new Result();
            result.setCode(ResultStatus.NOLOGIN);
            result.setErrMsg("用户未登录");
            return result;
        }
        PageResult<BookInfo> bookListByPage = bookService.getBookListByPage(pageRequest);
//        Result result = new Result();
//        result.setCode(ResultStatus.SUCCESS);
//        result.setData(bookListByPage);
//        return result;
        return Result.success(bookListByPage);
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

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") Integer bookID) {
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
    /**
     * 批量删除
     */
    @RequestMapping("/batchDeleteBook")
    public String batchDelete(@RequestParam List<Integer> ids) {
        log.info("批量删除图书, ids: {}" , ids);
        Integer result = bookService.batchDeleteBook(ids);
        if (result > 0) {
            return "";
        } else {
            return "内部错误";
        }
    }
}
