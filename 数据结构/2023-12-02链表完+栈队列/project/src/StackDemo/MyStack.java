package StackDemo;

public class MyStack {
    public int[] elem;
    public int usedSize;
    public static final int DEFAULT_CAPACITY = 10;
    public MyStack() {
        this.elem = new int[DEFAULT_CAPACITY];
    }
    public void push(int val) {
        if (isFull()) {
        }
    }

    public boolean isFull() {
        return usedSize== elem.length;
    }

    public int pop() {

    }
    public int peek() {

    }

}
