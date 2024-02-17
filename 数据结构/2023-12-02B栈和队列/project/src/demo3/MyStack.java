package demo3;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> qu1;
    Queue<Integer> qu2;

    public MyStack() {
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
    }

    public void push(int x) {
        if (empty()) {
            qu1.offer(x);
            return;
        }
        if (qu1.isEmpty()) {
            qu2.offer(x);
        } else {
            qu1.offer(x);
        }
    }

    public int pop() {
        if (empty()) {
            return -1;
        }
        if (!qu1.isEmpty()) {
            int size = qu1.size();
            for (int i = 0; i < size-1; i++) {
                qu2.offer(qu1.poll());
            }
            return qu1.poll();
        } else {
            int size = qu2.size();
            for (int i = 0; i < size-1; i++) {
                qu1.offer(qu2.poll());
            }
            return qu2.poll();
        }
    }

    public int top() {
        if (empty()) {
            return -1;
        }
        int ret = -1;
        if (!qu1.isEmpty()) {
            int size = qu1.size();
            for (int i = 0; i < size; i++) {
                ret = qu1.poll();
                qu2.offer(ret);
            }
            return ret;
        } else {
            int size = qu2.size();
            for (int i = 0; i < size; i++) {
                ret = qu2.poll();
                qu1.offer(ret);
            }
            return ret;
        }
    }

    public boolean empty() {
        return qu1.isEmpty()&&qu2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */