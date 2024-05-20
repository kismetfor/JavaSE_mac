package com.bite.springmvc.demos;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
@RequestMapping("/session")
@RestController
public class SessionController {
    @RequestMapping("/getC")
    public String getCookie(HttpServletRequest request, HttpServletResponse response) {
        //获取参数
//        String name = request.getParameter("name");
        Cookie[] cookies = request.getCookies();
        if (cookies!=null) {
            Arrays.stream(cookies).forEach(ck -> System.out.println(ck.getName()+": "+ck.getValue()));
        }
        return "获取Cookie";
    }

    //使用spring获取Cookie
    @RequestMapping("/getC2")
    public String getCookie2(@CookieValue("bite") String bite) {
        return "获取Cookie2 bite: "+bite;
    }

    @RequestMapping("/setSess")
    public String setSess(HttpServletRequest request) {
        //从Cookie中获取到了sessionID, 根据session获取session对象, 如果没有获取到 创建一个session对象
        HttpSession session = request.getSession();
        session.setAttribute("name", "zhangsan");
        return "设置session成功";
    }

    @RequestMapping("/getSess")
    public String getSess(HttpServletRequest request) {
        //从Cookie中获取到了sessionID, 根据session获取session对象
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        return "获取Session中 name: "+name;
    }
    @RequestMapping("/getSess2")
    public String getSess2(HttpSession session) {
        String name = (String) session.getAttribute("name");
        return "获取Session中 name: "+name;
    }
    @RequestMapping("/getSess3")
    public String getSess3(@SessionAttribute("name") String name) {
        return "getSess3 获取Session中 name: "+ name;
    }
    @RequestMapping("/getHeader")
    public String getHeader(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        return "从Header中获取信息 User-Agent="+userAgent;
    }
    @RequestMapping("/getHeader2")
    public String getHeader2(@RequestHeader("User-Agent") String userAgent) {
        return "getHeader2 从Header中获取信息 User-Agent="+userAgent;
    }
}
