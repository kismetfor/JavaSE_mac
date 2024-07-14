package com.example.java_gobang.api;

import com.example.java_gobang.game.*;
import com.example.java_gobang.model.User;
import com.example.java_gobang.model.UserMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.annotation.Resource;
import javax.print.DocFlavor;
import java.io.IOException;

@Component
public class GameAPI extends TextWebSocketHandler {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private RoomManager roomManager;
    @Autowired
    private OnlineUserManager onlineUserManager;

    @Resource
    private UserMapper userMapper;

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
        Room room = roomManager.getRoomByUserId(user.getUserId());
        if (room == null) { //匹配未成功进来的
            response.setOk(false);
            response.setReason("当前用户尚未匹配成功");
            String json = objectMapper.writeValueAsString(response);
            session.sendMessage(new TextMessage(json));
            return;
        }
        if (onlineUserManager.getFromGameRoom(user.getUserId()) != null
        || onlineUserManager.getFromGameHall(user.getUserId()) != null) { //多开的 账户多处登录的
            response.setOk(true);
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
                return;
            }
        }

        // 6. 此处如果又有玩家尝试连接同一个房间, 就提示报错.
        //    这种情况理论上是不存在的, 为了让程序更加的健壮, 还是做一个判定和提示.
        response.setOk(false);
        response.setReason("当前房间已满, 您不能加入房间");
        session.sendMessage(new TextMessage(objectMapper.writeValueAsString(response)));


    }

    private void noticeGameReady(Room room, User thisUser, User thatUser) throws IOException {
        GameReadyResponse resp = new GameReadyResponse();
        resp.setMessage("gameReady");
        resp.setOk(true);
        resp.setReason("");
        resp.setRoomId(room.getRoomId());
        resp.setThisUserId(thisUser.getUserId());
        resp.setThatUserId(thatUser.getUserId());
        resp.setWhiteUser(room.getWhiteUser());
        // 把当前的响应数据传回给玩家.
        WebSocketSession webSocketSession = onlineUserManager.getFromGameRoom(thisUser.getUserId());
        webSocketSession.sendMessage(new TextMessage(objectMapper.writeValueAsString(resp)));
    }



    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        User user = (User) session.getAttributes().get("user");
        if (user == null) {
            //加点日志
            System.out.println("[handleTextMessage] 当前玩家尚未登录! ");
            return;
        }
        Room room = roomManager.getRoomByUserId(user.getUserId());
        //下棋
        room.putChess(message.getPayload());
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        User user = (User) session.getAttributes().get("user");
        if (user == null) {
            // 此处就简单处理, 在断开连接的时候就不给客户端返回响应了.
            return;
        }
        WebSocketSession exitSession = onlineUserManager.getFromGameRoom(user.getUserId());
        if (session == exitSession) {
            // 加上这个判定, 目的是为了避免在多开的情况下, 第二个用户退出连接动作, 导致第一个用户的会话被删除.
            onlineUserManager.exitGameRoom(user.getUserId());
        }
        System.out.println("当前用户 " + user.getUsername() + " 游戏房间连接异常!");

        // 通知对手获胜了
        noticeThatUserWin(user);
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
            noticeThatUserWin(user);
        } catch (NullPointerException e) {
            System.out.println("[MatchAPI.afterConnectionClosed] 当前用户未登录!");
        }

    }
    private void noticeThatUserWin(User user) throws IOException {
        // 1. 根据当前玩家, 找到玩家所在的房间
        Room room = roomManager.getRoomByUserId(user.getUserId());
        if (room == null) {
            // 这个情况意味着房间已经被释放了, 也就没有 "对手" 了
            System.out.println("当前房间已经释放, 无需通知对手!");
            return;
        }

        // 2. 根据房间找到对手
        User thatUser = (user == room.getUser1()) ? room.getUser2() : room.getUser1();
        // 3. 找到对手的在线状态
        WebSocketSession webSocketSession = onlineUserManager.getFromGameRoom(thatUser.getUserId());
        if (webSocketSession == null) {
            // 这就意味着对手也掉线了!
            System.out.println("对手也已经掉线了, 无需通知!");
            return;
        }
        // 4. 构造一个响应, 来通知对手, 你是获胜方
        GameResponse resp = new GameResponse();
        resp.setMessage("putChess");
        resp.setUserId(thatUser.getUserId());
        resp.setWinner(thatUser.getUserId());
        webSocketSession.sendMessage(new TextMessage(objectMapper.writeValueAsString(resp)));

        // 5. 更新玩家的分数信息
        int winUserId = thatUser.getUserId();
        int loseUserId = user.getUserId();
        userMapper.userWin(winUserId);
        userMapper.userLose(loseUserId);

        // 6. 释放房间对象
        roomManager.remove(room.getRoomId(), room.getUser1().getUserId(), room.getUser2().getUserId());
    }
}
