package com.bite.book.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BookInfo {
    //	图书ID
    private Integer id;
    //书名
    private String bookName;
    //	作者
    private String author;
    //	数量
    private Integer count;
    //	定价
    private BigDecimal price;
    //	出版社
    private String publish;
    //	状态
    private Integer status; //0--不可借阅 1--可借阅
    private String statusCN;
    private Date createTime;
    private Date updateTime;
}
