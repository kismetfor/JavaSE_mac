package com.example.java_gobang.game;

import com.example.java_gobang.GobangApplication;
import com.example.java_gobang.model.User;
import com.example.java_gobang.model.UserMapper;
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
    private static final int MAX_ROW = 15;
    private static final int MAX_COL = 15;
    private int[][] board = new int[MAX_ROW][MAX_COL];
    //objectMapper转换JSON格式
    private ObjectMapper objectMapper = new ObjectMapper();
    //onlineUserManager查询房间中的user信息
    private OnlineUserManager onlineUserManager;
    //roomManager销毁房间
    private RoomManager roomManager;

    private UserMapper userMapper;

    // 通过这个方法来处理一次落子操作.
    // 要做的事情:
    public void putChess(String reqJson) throws IOException {
        GameRequest request = objectMapper.readValue(reqJson, GameRequest.class);
//        if (request == null) {
//            System.out.println("反序列化后的请求对象为空!");
//            return;
//        }
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
        //打印棋盘信息
        printBoard();
        //胜负判定
        int winner= checkWinner(row, col, chess);
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
            System.out.println("玩家1 "+user1.getUsername()+"掉线");
        }
        if (session2 == null) {
            response.setWinner(user1.getUserId());
            System.out.println("玩家2 "+user2.getUsername()+"掉线");
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

    private void printBoard() {
        //写程序不仅要考虑项目的功能, 还要考虑代码的可读性 项目的可维护性 这里打印是为了更方便理解程序
        System.out.println("打印棋盘信息" + roomId);
        System.out.println("====================================");
        for (int i = 0; i < MAX_ROW; i++) {
            for (int j = 0; j < MAX_COL; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("====================================");

    }

    private int checkWinner(int row, int col, int chess) {
        //检查所有的行
        //五种情况 新添加的棋子可能是五子连珠中的第一二三四五个
        //不仅要连着 还要都是本玩家下的
        for (int c = col-4; c >=col ; c++) {
            try {
                if (board[row][c] == chess &&
                        board[row][c+1] == chess &&
                        board[row][c+2] == chess &&
                        board[row][c+3] == chess &&
                        board[row][c+4] == chess) {
                    return chess == 1 ? user1.getUserId() : user2.getUserId();
                }
            }catch (ArrayIndexOutOfBoundsException e) {
                //数组越界 就不考虑这种情况
                continue;
            }
        }
        // 2. 检查所有列
        for (int r = row - 4; r <= row; r++) {
            try {
                if (board[r][col] == chess
                        && board[r + 1][col] == chess
                        && board[r + 2][col] == chess
                        && board[r + 3][col] == chess
                        && board[r + 4][col] == chess) {
                    return chess == 1 ? user1.getUserId() : user2.getUserId();
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                continue;
            }
        }

        // 3. 检查左对角线
        for (int r = row - 4, c = col - 4; r <= row && c <= col; r++, c++) {
            try {
                if (board[r][c] == chess
                        && board[r + 1][c + 1] == chess
                        && board[r + 2][c + 2] == chess
                        && board[r + 3][c + 3] == chess
                        && board[r + 4][c + 4] == chess) {
                    return chess == 1 ? user1.getUserId() : user2.getUserId();
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                continue;
            }
        }


        // 4. 检查右对角线
        for (int r = row - 4, c = col + 4; r <= row && c >= col; r++, c--) {
            try {
                if (board[r][c] == chess
                        && board[r + 1][c - 1] == chess
                        && board[r + 2][c - 2] == chess
                        && board[r + 3][c - 3] == chess
                        && board[r + 4][c - 4] == chess) {
                    return chess == 1 ? user1.getUserId() : user2.getUserId();
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                continue;
            }
        }

        return 0;
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
        // 构造 Room 的时候生成一个唯一的字符串表示房间 id.
        // 使用 UUID 来作为房间 id
        roomId = UUID.randomUUID().toString();
        // 通过入口类中记录的 context 来手动获取到前面的 RoomManager 和 OnlineUserManager
        onlineUserManager = GobangApplication.context.getBean(OnlineUserManager.class);
        roomManager = GobangApplication.context.getBean(RoomManager.class);
        userMapper = GobangApplication.context.getBean(UserMapper.class);
    }

}
