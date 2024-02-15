package StackDemo;

import java.util.Arrays;

public class MyStack {
    public int[] elem;
    public int usedSize;
    public static final int DEFAULT_CAPACITY = 10;
    public MyStack() {
        this.elem = new int[DEFAULT_CAPACITY];
    }
    //压栈 / 入栈
    public void push(int val) {
        if (isFull()) {
            // 扩容
            this.elem = Arrays.copyOf(elem, 2*elem.length);
        }
        elem[usedSize++] = val;
    }

    public boolean isFull() {
        return usedSize== elem.length;
    }

    //弹出
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException("栈未空");
        }
        return elem[--usedSize];
    }

    public boolean isEmpty() {
        return usedSize==0;
    }
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException("栈未空");
        }
        return elem[usedSize-1];
    }

}
