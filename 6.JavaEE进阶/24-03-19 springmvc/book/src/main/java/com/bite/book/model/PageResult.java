package com.bite.book.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageResult<T> {
    private int code; //业务码 200成功 -1 失败 -2 未登录
    private String msg;
    private List<T> record;
    private Integer count;
    private PageRequest pageRequest;
}
