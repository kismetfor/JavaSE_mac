package com.example.java_gobang.api;

import com.example.java_gobang.game.*;
import com.example.java_gobang.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

@Component
public class GameAPI extends TextWebSocketHandler {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private RoomManager roomManager;
    @Autowired
    private OnlineUserManager onlineUserManager;
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        GameReadyResponse response = new GameReadyResponse();
        User user = (User) session.getAttributes().get("user");
        if (user == null) { //未登录直接访问game_hall.html
            response.setOk(false);
            response.setReason("用户尚未登录");
            String json = objectMapper.writeValueAsString(response);
            session.sendMessage(new TextMessage(json));

            return;
        }
        Room room = roomManager.getRoomIdByUserId(user.getUserId());
        if (room == null) { //匹配未成功进来的
            response.setOk(false);
            response.setReason("当前用户尚未匹配成功");
            String json = objectMapper.writeValueAsString(response);
            session.sendMessage(new TextMessage(json));
            return;
        }
        if (onlineUserManager.getFromGameRoom(user.getUserId()) != null
        || onlineUserManager.getFromGameHall(user.getUserId()) != null) { //多开的 账户多处登录的
            response.setOk(false);
            response.setReason("repeatConnection");
            response.setMessage("当前禁止多开");
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(response)));
            return;
        }

        //设置玩家上线
        onlineUserManager.enterGameRoom(user.getUserId(), session);
        synchronized (room) {
            if (room.getUser1() == null) {
                room.setUser1(user);
                //先匹配到的是先手
                room.setWhiteUser(user.getUserId());
                System.out.println("玩家 "+user.getUsername()+" 已经准备就绪");
                return;
            }

            if (room.getUser2() == null) {
                room.setUser2(user);
                System.out.println("玩家 "+user.getUsername()+" 已经准备就绪");
                // 当两个玩家都加入成功之后, 就要让服务器, 给这两个玩家都返回 websocket 的响应数据.
                // 通知这两个玩家说, 游戏双方都已经准备好了.
                // 通知玩家1
                noticeGameReady(room, room.getUser1(), room.getUser2());
                // 通知玩家2
                noticeGameReady(room, room.getUser2(), room.getUser1());
            }
        }

        // 6. 此处如果又有玩家尝试连接同一个房间, 就提示报错.
        //    这种情况理论上是不存在的, 为了让程序更加的健壮, 还是做一个判定和提示.
        response.setOk(false);
        response.setReason("当前房间已满, 您不能加入房间");
        session.sendMessage(new TextMessage(objectMapper.writeValueAsString(response)));


    }

    private void noticeGameReady(Room room, User thisuser, User thatuser) throws IOException {
        GameReadyResponse response = new GameReadyResponse();
        response.setOk(true);
        response.setReason("");
        response.setRoomId(room.getRoomId());
        response.setThisUserId(thisuser.getUserId());
        response.setThisUserId(thatuser.getUserId());
        response.setWhiteUser(room.getWhiteUser());
        response.setMessage("gameReady");
        // 把当前的响应数据传回给玩家.
        WebSocketSession webSocketSession = onlineUserManager.getFromGameRoom(thisuser.getUserId());
        webSocketSession.sendMessage(new TextMessage(objectMapper.writeValueAsString(response)));

    }



    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        User user = (User) session.getAttributes().get("user");
        if (user == null) {
            //加点日志
            System.out.println("[handleTextMessage] 当前玩家尚未登录! ");
            return;
        }
        Room room = roomManager.getRoomIdByUserId(user.getUserId());
        //下棋
        room.putChess(message.getPayload());
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        try {
            User user = (User)session.getAttributes().get("user");
            if (user == null) {
                return;
            }
            WebSocketSession exitSession = onlineUserManager.getFromGameRoom(user.getUserId());
            if (session == exitSession) {
                // 加上这个判定, 目的是为了避免在多开的情况下, 第二个用户退出连接动作, 导致第一个用户的会话被删除.
                onlineUserManager.exitGameRoom(user.getUserId());
            }
            System.out.println("当前用户 " + user.getUsername() + " 离开游戏房间!");

        } catch (NullPointerException e) {
            System.out.println("[MatchAPI.afterConnectionClosed] 当前用户未登录!");
        }

    }
}
