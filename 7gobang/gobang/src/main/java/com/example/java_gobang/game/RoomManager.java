package com.example.java_gobang.game;

import com.example.java_gobang.model.User;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 房间管理器
 */
@Component
public class RoomManager {
    private ConcurrentHashMap<String, Room> rooms = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, String> userIdByRoomId = new ConcurrentHashMap<>();
    public void add(Room room, int userId1, int userId2) {
        rooms.put(room.getRoomId(), room);
        userIdByRoomId.put(userId1, room.getRoomId());
        userIdByRoomId.put(userId2, room.getRoomId());
    }
    public void remove(String roomId,  int userId1, int userId2) {
        rooms.remove(roomId);
        userIdByRoomId.remove(userId1);
        userIdByRoomId.remove(userId2);
    }
    public Room getRoomByRoomId(String roomId) {
        return rooms.get(roomId);
    }
//    public User getUserIdByRoomId(String roomId) {
//        return rooms.get(roomId);
//    }
    public Room getRoomIdByUserId(int userId) {
        String roomId= userIdByRoomId.get(userId);
        if (roomId== null) {
            return null;
        }
        return rooms.get(roomId);
    }
}
