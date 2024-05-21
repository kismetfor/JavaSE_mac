package com.bite.book;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookInfo {
    //	图书ID
    private Integer id;
    //书名
    private String bookName;
    //	作者
    private String author;
    //	数量
    private Integer num;
    //	定价
    private BigDecimal price;
    //	出版社
    private String publishName;
    //	状态
    private Integer status; //0--不可借阅 1--可借阅
    private String statusCN;
}
