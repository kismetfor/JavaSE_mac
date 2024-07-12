package com.example.java_gobang.game;

import com.example.java_gobang.model.User;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Room {
    private String roomId;
    private User user1;
    private User user2;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public Room() {
        roomId = UUID.randomUUID().toString();

    }
}
