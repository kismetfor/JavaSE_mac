package com.example.java_gobang.api;

import com.example.java_gobang.game.MatchRequest;
import com.example.java_gobang.game.MatchResponse;
import com.example.java_gobang.game.Matcher;
import com.example.java_gobang.game.OnlineUserManager;
import com.example.java_gobang.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
@Component
public class MatchAPI extends TextWebSocketHandler {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private OnlineUserManager onlineUserManager;
    @Autowired
    private Matcher matcher;
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        //上线加入OnlineUserManager


        //    注意, 此处拿到的 user, 是有可能为空的!!
        //    如果之前用户压根就没有通过 HTTP 来进行登录, 直接就通过 /game_hall.html 这个 url 来访问游戏大厅页面
        //    此时就会出现 user 为 null 的情况
        //获取身份信息

        try {
            User user = (User)session.getAttributes().get("user");
//            WebSocketSession tmpSession = onlineUserManager.getFromGameHall(user.getUserId());
            if (onlineUserManager.getFromGameRoom(user.getUserId()) != null
                    || onlineUserManager.getFromGameHall(user.getUserId()) != null) { //多开的 账户多处登录的
                MatchResponse response = new MatchResponse();
                response.setOk(true);
                response.setReason("账号已经在其他地方登陆了!!!");
                 response.setMessage("repeatConnection");
                session.sendMessage(new TextMessage(objectMapper.writeValueAsString(response)));

                return;
            }
            //把玩家设置为在线状态
            onlineUserManager.enterGameHall(user.getUserId(), session);
            System.out.println("玩家"+user.getUsername()+"进入游戏大厅");

        } catch (NullPointerException e) {
            System.out.println("[MatchAPI.afterConnectionEstablished] 当前用户未登录!");
            // e.printStackTrace();
            // 出现空指针异常, 说明当前用户的身份信息是空, 用户未登录呢.
            // 把当前用户尚未登录这个信息给返回回去~~
            MatchResponse response = new MatchResponse();
            response.setOk(false);
            response.setReason("您尚未登录! 不能进行后续匹配功能!");
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(response)));
        }
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        try {
            // 玩家下线, 从 OnlineUserManager 中删除
            User user = (User) session.getAttributes().get("user");
            String payload = message.getPayload();
            //JSON -> Java对象
            MatchRequest request = objectMapper.readValue(payload, MatchRequest.class);
            MatchResponse response = new MatchResponse();
            if (request.getMessage().equals("startMatch")) {
                // TODO 先创建一个类表示匹配队列, 把当前用户给加进去
                matcher.add(user);
                response.setOk(true);
                response.setMessage("startMatch");
            } else if (request.getMessage().equals("stopMatch")) {
                //TODO 先创建一个类表示匹配队列, 把当前用户移除
                matcher.remove(user);
                response.setOk(true);
                response.setMessage("stopMatch");
            } else {
                response.setOk(false);
                response.setMessage("非法匹配请求");
            }
            String jsonString = objectMapper.writeValueAsString(response);
            session.sendMessage(new TextMessage(jsonString));

        } catch (NullPointerException e) {
            System.out.println("[MatchAPI.handleTextMessage] 当前用户未登录!");
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        super.handleTransportError(session, exception);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        try {
            // 玩家下线, 从 OnlineUserManager 中删除
            User user = (User) session.getAttributes().get("user");
            WebSocketSession tmpSession = onlineUserManager.getFromGameHall(user.getUserId());
            if (tmpSession == session) {
                onlineUserManager.exitGameHall(user.getUserId());
            }
            // 如果玩家正在匹配中, 而 websocket 连接断开了, 就应该移除匹配队列
            matcher.remove(user);
        } catch (NullPointerException e) {
            System.out.println("[MatchAPI.afterConnectionClosed] 当前用户未登录!");
            // e.printStackTrace();

        }
    }
}
