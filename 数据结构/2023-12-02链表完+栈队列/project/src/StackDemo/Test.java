package StackDemo;

import java.util.LinkedList;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());

        System.out.println(stack.peek());
    }
    public static void main1(String[] args) {
        MyStack stack = new MyStack();
        stack.push(12);
        stack.push(23);
        stack.push(34);
        stack.push(45);

        //pop 删除元素
        Integer ret = stack.pop();
        System.out.println(ret);

        //peek 获取元素 但是不删除
        Integer ret1 = stack.peek();
        System.out.println(ret1);

        System.out.println(stack.isEmpty());
    }
}
