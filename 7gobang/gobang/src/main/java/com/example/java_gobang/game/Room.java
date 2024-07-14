package com.example.java_gobang.game;

import com.example.java_gobang.GobangApplication;
import com.example.java_gobang.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.UUID;

//这里Roo不只有一个 所以不应该加上Component注解 加上了就是单例模式
//@Component
public class Room {
    private String roomId;
    private User user1;
    private User user2;
    // 先手方的玩家 id
    private int whiteUser;
    private int[][] board = new int[15][15];
    //objectMapper转换JSON格式
    private ObjectMapper objectMapper = new ObjectMapper();
    //onlineUserManager查询房间中的user信息
    private OnlineUserManager onlineUserManager;
    //roomManager销毁房间
    private RoomManager roomManager;
    // 通过这个方法来处理一次落子操作.
    // 要做的事情:
    public void putChess(String reqJson) throws IOException {
        GameRequest request = objectMapper.readValue(reqJson, GameRequest.class);
        if (request == null) {
            System.out.println("反序列化后的请求对象为空!");
            return;
        }
        GameResponse response = new GameResponse();
//        /玩家1还是玩家2的落子
        int chess = request.getUserId() == user1.getUserId() ? 1: 2;
        int row = request.getRow();
        int col = request.getCol();
        if (board[row][col] != 0) {
            // 在客户端已经针对重复落子进行过判定了. 此处为了程序更加稳健, 在服务器再判定一次.
            System.out.println("当前位置 (" + row + ", " + col + ") 已经有子了!");
            return;
        }

        board[row][col] = chess;
        //胜负判定
        int winner= checkWinner(row, col);
        //给客户端返回响应 两个都要发送
        response.setMessage("putChess");
        response.setUserId(request.getUserId());
        response.setRow(row);
        response.setCol(col);
        response.setWinner(winner);

        // 要想给用户发送 websocket 数据, 就需要获取到这个用户的 WebSocketSession
        WebSocketSession session1 = onlineUserManager.getFromGameRoom(user1.getUserId());
        WebSocketSession session2 = onlineUserManager.getFromGameRoom(user2.getUserId());

        // 万一当前查到的会话为空(玩家已经下线了) 特殊处理一下
        if (session1 == null) {
            //玩家1突然下线 玩家2赢了
            response.setWinner(user2.getUserId());
            System.out.println("玩家"+user1.getUsername()+"掉线");
        }
        if (session2 == null) {
            response.setWinner(user1.getUserId());
            System.out.println("玩家"+user2.getUsername()+"掉线");
        }
        // 把响应构造成 JSON 字符串, 通过 session 进行传输.
        String respJSON = objectMapper.writeValueAsString(response);
        if (session1 != null) {
            session1.sendMessage(new TextMessage(respJSON));
        }
        if (session2 != null) {
            session2.sendMessage(new TextMessage(respJSON));
        }

        // 5. 如果当前胜负已分, 此时这个房间就失去存在的意义了. 就可以直接销毁房间. (把房间从房间管理器中给移除)
        if (response.getWinner() != 0) {
            System.out.println("游戏结束! 房间即将销毁! roomId=" + roomId + " 获胜方为: " + response.getWinner());
            int winUserId = response.getWinner();
            int loseUserId = response.getWinner() == user1.getUserId() ? user2.getUserId() : user1.getUserId();
//            userMapper.userWin(winUserId);
//            userMapper.userLose(loseUserId);
            roomManager.remove(roomId, user1.getUserId(), user2.getUserId());
            System.out.println("销毁房间");
        }



    }

    private int checkWinner(int row, int col) {
        // TODO winner
        //记录落子的位置

        //进行胜负判定

        //给客户端返回响应
        return 1;
    }

    public int getWhiteUser() {
        return whiteUser;
    }

    public void setWhiteUser(int whiteUser) {
        this.whiteUser = whiteUser;
    }

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
        onlineUserManager = GobangApplication.context.getBean(OnlineUserManager.class);
        roomManager = GobangApplication.context.getBean(RoomManager.class);
    }

}
