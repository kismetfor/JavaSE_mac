package demo1;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(12);
        stack.add(23);
        stack.add(34);
        stack.add(45);

        //pop 删除元素
        Integer ret = stack.pop();
        System.out.println(ret);

        //peek 获取元素 但是不删除
        Integer ret1 = stack.peek();
        System.out.println(ret1);
    }
}
