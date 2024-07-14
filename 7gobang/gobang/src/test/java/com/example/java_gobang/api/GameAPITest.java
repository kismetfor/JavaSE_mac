package com.example.java_gobang.api;

import com.example.java_gobang.api.GameAPI;
import com.example.java_gobang.game.*;
import com.example.java_gobang.model.User;
import com.example.java_gobang.model.UserMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@SpringBootTest
class GameAPITest {



    @Autowired
    private OnlineUserManager onlineUserManager;


    @Autowired
    private GameAPI gameAPI;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void afterConnectionEstablished_roomAlreadyHasTwoUsers() throws Exception {
        // 模拟第一个用户
        User user1 = new User();
        user1.setUserId(1);
        user1.setUsername("User1");

        // 模拟第二个用户
        User user2 = new User();
        user2.setUserId(2);
        user2.setUsername("User2");

        // 模拟一个已经有两个用户的房间
        Room room = new Room();
        room.setUser1(user1);
        room.setUser2(user2);
        gameAPI.afterConnectionEstablished(onlineUserManager.getFromGameRoom(user1.getUserId()));
        System.out.println();
    }
}
