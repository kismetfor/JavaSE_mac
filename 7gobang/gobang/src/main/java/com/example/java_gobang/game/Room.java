package com.example.java_gobang.game;

import com.example.java_gobang.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class Room {
    private String roomId;
    private User user1;
    private User user2;
    // 先手方的玩家 id
    private int whiteUser;
    private int[][] board = new int[15][15];
    private ObjectMapper objectMapper;
    // 通过这个方法来处理一次落子操作.
    // 要做的事情:
    public void putChess(String reqJson) throws IOException {
        GameRequest request = objectMapper.readValue(reqJson, GameRequest.class);
        GameResponse response = new GameResponse();
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
    }

    private int checkWinner(int row, int col) {
        // TODO winner
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

    }

}
