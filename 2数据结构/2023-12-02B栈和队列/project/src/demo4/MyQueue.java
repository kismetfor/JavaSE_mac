package demo4;

import java.util.Stack;

class MyQueue {
    //入队栈
    Stack<Integer> s1;
    //出队栈
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        if (s1.empty()) {
            int size = s2.size();
            for (int i = 0; i < size; i++) {
                s1.push(s2.pop());
            }
        }
        s1.push(x);
    }

    public int pop() {
        if (empty()) {
            return -1;
        }
        if (s1.empty()) {
            return s2.pop();
        } else {
            int size = s1.size();
            for (int i = 0; i<size-1; i++) {
                s2.push(s1.pop());
            }
            return s1.pop();
        }
    }

    public int peek() {
        if (empty()) {
            return -1;
        }
        if (s2.empty()) {
            int size = s1.size();
            for (int i = 0; i<size; i++) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean empty() {
        return s1.empty()&&s2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */