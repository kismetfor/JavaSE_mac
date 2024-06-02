package com.bite.springmvc.demos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@RequestMapping("/res")
@Controller
public class ResponseController {
    @RequestMapping("/index")
    public String index() {
        return "/html/Index.html";
    }
    @ResponseBody
    @RequestMapping("/indexData")
    public String indexData() {
        return "返回数据";
    }

    @ResponseBody
    @RequestMapping("/indexData2")
    public String indexData2() {
        return "<h1>我是中国人<h1>";
    }

    @ResponseBody
    @RequestMapping("/getMap")
    public HashMap<String, String> getMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        map.put("k4", "v4");
        return map;
    }

    //418表示“I’m a teapot”（我是一个茶壶）
    @ResponseBody
    @RequestMapping("/setStatus")
    public String setStatus(HttpServletResponse response) {
        response.setStatus(418);
        return "设置状态码";
    }
    @ResponseBody
    @RequestMapping(value = "setContentType" , produces = "application/json")
    public String setContentType() {
        return "{\"OK\":1}";
    }
}
