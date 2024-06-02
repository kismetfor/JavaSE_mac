package com.bite.springmvc.demos.controller;

import com.bite.springmvc.demos.model.Student;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/request")
@RestController
public class RequestController {
    @RequestMapping(value = "/hello" ,  method = RequestMethod.GET)
    public String say() {
        return "hello, spring mvc";
    }
    @RequestMapping("r1")
    public String r1(String name) {
        return "接收到参数, name = " + name;
    }
    @RequestMapping("r2")
    public String r2(Integer age) {
        return "接收到参数, age = " + age;
    }
    @RequestMapping("r3")
    public String r3(int age) {
        return "r3接收到参数, age = " + age;
    }
    @RequestMapping("r4")
    public String r4(String name, Integer age) {
        return "r4接收到参数, name = " + name+
                " , 接收到参数, age = " + age;
    }
    @RequestMapping("r5")
    public String r5(Student student) {
        return "r5接收到参数  " + student.toString();
    }
    @RequestMapping("r6")
    public String r6(@RequestParam("name") String username) {
        return "r6接收到参数, name:  " + username;
    }
    @RequestMapping("r7")
    public String r7(@RequestParam(value = "name", required = false) String username) {
        return "r7接收到参数, name:  " + username;
    }
    @RequestMapping("r8")
    public String r8(String[] array) {
        return "r8接收到参数, array:  " + Arrays.toString(array);
    }
    @RequestMapping("r9")
    public String r9(@RequestParam List<String> list) {
        return "r9接收到参数, list:  " + list;
    }
    /**
     * 接收JSON
     */
    @RequestMapping("r10")
    public String r10(Student student) {
        return "r10接收到参数, student:  " + student.toString();
    }
    @RequestMapping("r11")
    public String r11(@RequestBody Student student) {
        return "r11接收到参数, student:  " + student.toString();
    }
    @RequestMapping("/article/{articleID}/{name}")
    public String r12(@PathVariable("articleID") Integer articleID, @PathVariable("name") String name) {
        return "r12接收到参数, articleID:  " + articleID+"  name: "+ name;
    }
    @RequestMapping("r13")
    public String r13(@RequestPart("file") MultipartFile imgFile) {
        String originalFileName = imgFile.getOriginalFilename();
        return "r13接收到文件名:  " + originalFileName;
    }

}
