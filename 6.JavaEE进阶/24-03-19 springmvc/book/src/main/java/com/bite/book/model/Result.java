package com.bite.book.model;

import com.bite.book.enums.ResultStatus;
import lombok.Data;

@Data
public class Result<T> {
    private ResultStatus code; //业务码 200成功 -2失败 -1未登录
    private String errMsg; //错误信息 如果业务成功 那么errMsg为空
    private T pageResult;
    private T data;

    public static <T> Result success(T data) {
        Result result = new Result();
        result.setCode(ResultStatus.SUCCESS);
        result.setData(data);
        return result;
    }
    public static <T> Result noLogin(T data) {
        Result result = new Result();
        result.setCode(ResultStatus.SUCCESS);
        result.setData(data);
        return result;
    }
}
