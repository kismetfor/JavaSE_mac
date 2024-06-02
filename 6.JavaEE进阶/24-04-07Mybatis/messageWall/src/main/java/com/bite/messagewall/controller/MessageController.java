package com.bite.messagewall.controller;

import com.bite.messagewall.model.MessageInfo;
import com.bite.messagewall.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private MessageService messageService;

    /**
     * 获取留言信息
     * @return
     */
    @RequestMapping("/getList")
    public List<MessageInfo> getList() {
        return messageService.getMessageList();
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
                !StringUtils.hasLength(messageInfo.getMessage())) {
            return false;
        }
        Integer i = messageService.publishMessage(messageInfo);
        if (i>0) return true;
        return false;
    }
}
