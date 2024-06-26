package com.bite.springmvc.demos.model;

import lombok.Data;

import java.util.Date;

@Data
public class MessageInfo {
    private Integer id;
    private String from;
    private String to;
    private String say;
    private Integer delete_flag;
    private Date create_time;
    private Date update_time;
}
