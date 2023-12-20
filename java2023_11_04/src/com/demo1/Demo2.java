package com.demo1;
//此处Demo1和Demo2用来测试private
//同一包中的同一类可以
//同一包中的不同类不行
import com.demo1.Demo1;
public class Demo2 {
    public static void main(String[] args) {
        Demo1 t = new Demo1();
        System.out.println(t.age);
    }

}
