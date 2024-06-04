package com.bite.book.enums;

public enum BookStatus {
    DELETE(0, "删除"),
    NORMAL(1, "可借阅"),
    FORBIDDEN(2, "不可借阅"),
    ;


    BookStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    private Integer status;
    private String desc;


    public static BookStatus getDescByCode(Integer code) {
        switch (code) {
            case 0: return DELETE;
            case 1: return NORMAL;
            case 2:
            default:
                return FORBIDDEN;
        }
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
