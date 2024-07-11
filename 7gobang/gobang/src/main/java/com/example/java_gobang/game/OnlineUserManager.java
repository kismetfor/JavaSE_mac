package com.example.java_gobang.game;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashMap;
@Component
public class OnlineUserManager {
    //键值对存储游戏用户是否在线大厅状态
    private HashMap<Integer, WebSocketSession> gameHall = new HashMap<>();

    public void enterGameHall(int userId, WebSocketSession webSocketSession) {
        gameHall.put(userId, webSocketSession);
    }

    public void exitGameHall(int userId, WebSocketSession webSocketSession) {
        gameHall.remove(userId, webSocketSession);
    }


    public WebSocketSession getFromGameHall(int userId, WebSocketSession webSocketSession) {
        return gameHall.get(userId);
    }
}
