package Stack和Queue;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    int size;
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        size = 0;
    }
    
    public void push(int x) {
        size++;
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.offer(x);
            return;
        }
        if (queue1.isEmpty() && !queue2.isEmpty()) {
            queue2.offer(x);
            return;
        }
        if (!queue1.isEmpty() && queue2.isEmpty()) {
            queue1.offer(x);
        }
    }
    
    public int pop() {
        if (empty()) return -1;
        int tmp = size;size--;
        if (queue1.isEmpty()) {
            while (--tmp != 0) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        } else {
            while (--tmp != 0) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }
    }
    
    public int top() {
        if (empty()) return -1;
        if (size == 1) {
            if (queue1.isEmpty()) {
                return queue2.peek();
            } else {
                return queue1.peek();
            }
        }
        int tmp = size;
        if (queue1.isEmpty()) {
            while (--tmp != 0) {
                queue1.offer(queue2.poll());
            }
            int t = queue2.poll();
            queue1.offer(t);
            return t;

        } else {
            while (--tmp != 0) {
                queue2.offer(queue1.poll());
            }
            int t = queue1.poll();
            queue2.offer(t);
            return t;
        }
    }
    
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
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