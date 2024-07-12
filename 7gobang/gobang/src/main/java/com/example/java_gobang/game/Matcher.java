package com.example.java_gobang.game;

import com.example.java_gobang.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 匹配器 匹配功能
 */
@Component
public class Matcher {
    private Queue<User> normalQueue = new LinkedList<>();
    private Queue<User> highQueue = new LinkedList<>();
    private Queue<User> veryHighQueue = new LinkedList<>();
    @Autowired
    private OnlineUserManager onlineUserManager;
    @Autowired
    private RoomManager roomManager;
    private ObjectMapper objectMapper = new ObjectMapper();
    //玩家点击匹配按钮 将玩家加入到匹配队列中
    public void add(User user) {
        if (user.getScore() < 2000) {
            synchronized (normalQueue) {
                normalQueue.offer(user);
                normalQueue.notify();
            }
            System.out.println("把玩家 " + user.getUsername() + " 加入到了 normalQueue 中!");
        } else if (user.getScore() >= 2000 && user.getScore() < 3000) {
            synchronized (highQueue) {
                highQueue.offer(user);
                highQueue.notify();
            }

            System.out.println("把玩家 " + user.getUsername() + " 加入到了 highQueue 中!");

        } else {
            synchronized (veryHighQueue) {
                veryHighQueue.offer(user);
                veryHighQueue.notify();
            }
            System.out.println("把玩家 " + user.getUsername() + " 加入到了 veryHighQueue 中!");

        }
    }

    //玩家点击停止匹配 将玩家移除匹配队列
    public void remove(User user) {
        if (user.getScore() < 2000) {
            synchronized (normalQueue) {
                normalQueue.remove(user);
            }
            System.out.println("把玩家 " + user.getUsername() + " 移除了 normalQueue 中!");
        } else if (user.getScore() >= 2000 && user.getScore() < 3000) {
            synchronized (highQueue) {
                highQueue.remove(user);
            }
            System.out.println("把玩家 " + user.getUsername() + " 移除了 highQueue 中!");
        } else {
            synchronized (veryHighQueue) {
                veryHighQueue.remove(user);
            }
            System.out.println("把玩家 " + user.getUsername() + " 移除了 veryHighQueue 中!");
        }
    }
    //创建三个线程 分别对三个队列进行同时操作

    public Matcher() {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) { //忙等
                    handlerMatch(normalQueue);
                }

            }
        };
        t1.start();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    handlerMatch(highQueue);
                }

            }
        };
        t2.start();
        Thread t3 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    handlerMatch(veryHighQueue);
                }

            }
        };
        t3.start();
    }
    //扫描队列
    private void handlerMatch(Queue<User> matchQueue) {
        synchronized (matchQueue) {
            try {
                //检测队列元素是否>2
                //这里为什么不用if
                //因为notify唤醒有可能只有一个queue
                while (matchQueue.size() < 2) {
                    matchQueue.wait();
                }
                //尝试从队列中取出两个元素
                User player1 = matchQueue.poll();
                User player2 = matchQueue.poll();
                System.out.println("匹配到两个玩家" + player1.getUsername()+ ", "+player2.getUsername());
                //获取websocket
                WebSocketSession session1 = onlineUserManager.getFromGameHall(player1.getUserId());
                WebSocketSession session2 = onlineUserManager.getFromGameHall(player2.getUserId());
                if (session1 == null) {
                    // 如果玩家1 现在不在线了, 就把玩家2 重新放回到匹配队列中
                    matchQueue.offer(player2);
                    return;
                }
                if (session2 == null) {
                    // 如果玩家1 现在不在线了, 就把玩家2 重新放回到匹配队列中
                    matchQueue.offer(player1);
                    return;
                }
                //匹配到同一个用户
                if (session1 == session2) {
                    // 把其中的一个玩家放回匹配队列.
                    matchQueue.offer(player1);
                    return;
                }
                //TODO 把两个玩家放到一个游戏房间中
                Room room  = new Room();
                roomManager.add(room, player1.getUserId() , player2.getUserId());

                // 5. 给玩家反馈信息: 你匹配到对手了~
                //    通过 websocket 返回一个 message 为 'matchSuccess' 这样的响应
                //    此处是要给两个玩家都返回 "匹配成功" 这样的信息.
                //一个TextMessage对应一个webSocket
                //    因此就需要返回两次
                MatchResponse response1 = new MatchResponse();
                response1.setOk(true);
                response1.setMessage("matchSuccess");
                String json1 = objectMapper.writeValueAsString(response1);
                session1.sendMessage(new TextMessage(json1));

                MatchResponse response2 = new MatchResponse();
                response1.setOk(true);
                response1.setMessage("matchSuccess");
                String json2 = objectMapper.writeValueAsString(response2);
                session1.sendMessage(new TextMessage(json2));

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        }

}
