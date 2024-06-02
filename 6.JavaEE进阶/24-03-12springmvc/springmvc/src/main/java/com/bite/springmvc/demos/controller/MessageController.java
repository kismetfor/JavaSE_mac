package com.bite.springmvc.demos.controller;

import com.bite.springmvc.demos.model.MessageInfo;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//http://127.0.0.1:8080/message/publish
@RestController
@RequestMapping("/message")
public class MessageController {
    private List<MessageInfo> messageInfos = new ArrayList<>();

    /**
     * 获取留言信息
     * @return
     */
    @RequestMapping("/getList")
    public List<MessageInfo> getList() {
        return messageInfos;
    }

    /**
     * 发布留言信息
     * @param messageInfo
     * @return
     */
    @RequestMapping("/publish")
    public Boolean publish(MessageInfo messageInfo) {
        System.out.println("接收参数, messageInfo: " + messageInfo);
        if (!StringUtils.hasLength(messageInfo.getFrom()) ||
                !StringUtils.hasLength(messageInfo.getTo()) ||
                !StringUtils.hasLength(messageInfo.getSay())) {
            return false;
        }
        messageInfos.add(messageInfo);
        return true;
    }
}
