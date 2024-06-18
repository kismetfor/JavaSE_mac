package Stack和Queue;

import java.util.Stack;

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int size;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        size = 0;
    }
    
    public void push(int x) {
        size++;
        stack1.push(x);
    }
    
    public int pop() {
        int tmp = size;
        while (--tmp != 0) {
            stack2.push(stack1.pop());
        }
        int ret = stack1.pop();
        tmp = size;
        while (--tmp != 0) {
            stack1.push(stack2.pop());
        }
        size--;
        return ret;
    }
    
    public int peek() {
        int tmp = size;
        while (--tmp != 0) {
            stack2.push(stack1.pop());
        }
        int ret = stack1.peek();
        tmp = size;
        while (--tmp != 0) {
            stack1.push(stack2.pop());
        }
        return ret;
    }
    
    public boolean empty() {
        return stack1.isEmpty();
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