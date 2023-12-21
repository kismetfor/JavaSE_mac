package com.bit.www;

public class Test {
    public static void main(String[] args) {
        Student s = new Student("徐涛", "A202", 12);
        System.out.println(s.getAge());
        s.setName("张雨潇");
        System.out.println(s.getName());
        System.out.println(s);
    }
}
