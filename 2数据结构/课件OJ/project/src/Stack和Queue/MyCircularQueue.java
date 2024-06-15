package Stack和Queue;

class MyCircularQueue {
    int[] elems;
    int front = 0;
    int rear = 0;
    int size;
    public MyCircularQueue(int k) {
        elems = new int[k+1];
        size = k+1;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        elems[rear] = value;
        rear = (rear+1)%size;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front+1)%size;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        return elems[front];
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        if (rear == 0) return elems[size-1];
        return elems[rear-1];
    }
    
    public boolean isEmpty() {
        return front==rear;
    }
    
    public boolean isFull() {
        return (rear+1)%size == front;
    }
}
