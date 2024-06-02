package com.bite.springmvc.demos.model;

import lombok.Data;

import java.util.Date;

@Data
public class MessageInfo {
    //        `message` VARCHAR ( 256 ) NOT NULL,
    //        `delete_flag` TINYINT ( 4 ) DEFAULT 0 COMMENT '0-正常, 1-删除',
    //        `create_time` DATETIME DEFAULT now(),
    //        `update_time` DATETIME DEFAULT now() ON UPDATE now(),
    private Integer id;
    private String from;
    private String to;
    private String say;
    private Integer delete_flag;
    private Date create_time;
    private Date update_time;
}
