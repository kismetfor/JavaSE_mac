package com.example.java_gobang.api;

import com.example.java_gobang.model.User;
import com.example.java_gobang.model.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserAPI {
    //@Autowired注入方式：默认按类型注入（by type）。
    //@Resource注入方式：默认按名称注入（by name）。
    //如果找不到名称匹配的 bean，会回退到按类型注入（by type）。
    @Resource
    private UserMapper userMapper;
    @PostMapping("/login")
    @ResponseBody
    public Object login(String username, String password, HttpServletRequest request) {
        //关键操作: 根据username去数据库查询
        // 如果能找到匹配的用户并且密码一致, 就确认为登陆成功
        User user = userMapper.selectByName(username);
        if (user == null || !user.getPassword().equals(password)) {
            System.out.println("登录失败");
            return new User(); //这是空对象 说明登录失败
        }
        //这里的true表示如果会话存在, 那么返回session, 不存在创建一个新的会话返回
        HttpSession httpSession = request.getSession(true);
        httpSession.setAttribute("user", user);
        return user;
    }
    @PostMapping("/register")
    @ResponseBody
    public Object register(String username, String password) {
        try {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            //天梯分数新手默认1200
            user.setScore(1200);
            user.setWinCount(0);
            user.setTotalCount(0);
            userMapper.insert(user);
            return user;
        } catch (org.springframework.dao.DuplicateKeyException e) {
            //key重复异常
            User user = new User();
            return user;
        }

    }

    /**
     * 发生的错误[WARN ] - Resolved [org.springframework.web.HttpRequestMethodNotSupportedException: Request method 'GET' not supported]  登录后跳转到http://127.0.0.1:8080/game_hall.html
     * 获取用户信息失败!
     * 这里是因为之前写的是PostMapping 改为GetMapping
     * @param request
     * @return
     */
    @GetMapping("/userInfo")
    @ResponseBody
    public Object getUserInfo(HttpServletRequest request) {
        try {
            HttpSession httpSession = request.getSession(false);
            User user = (User) httpSession.getAttribute("user");
            User newUser = userMapper.selectByName(user.getUsername());
            return newUser;
        } catch (NullPointerException e) {
            return new User();
        }
    }
}
