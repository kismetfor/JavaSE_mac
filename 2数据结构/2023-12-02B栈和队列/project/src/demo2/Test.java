package demo2;

public class Test {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(6); // 设置长度为 3
        System.out.println(circularQueue.enQueue(6));  // 返回 true
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.deQueue());  // 返回 true

        System.out.println(circularQueue.enQueue(5));  // 返回 true

        System.out.println(circularQueue.Rear());  // 返回 4
        System.out.println(circularQueue.deQueue());  // 返回 true

        System.out.println(circularQueue.Front());
        System.out.println(circularQueue.deQueue());  // 返回 true
        System.out.println(circularQueue.deQueue());  // 返回 true
        System.out.println(circularQueue.deQueue());  // 返回 true



    }
    public static void main1(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        System.out.println(circularQueue.enQueue(1));  // 返回 true
        System.out.println(circularQueue.enQueue(2));  // 返回 true
        System.out.println(circularQueue.enQueue(3));  // 返回 true
        System.out.println(circularQueue.enQueue(4));  // 返回 false，队列已满
        System.out.println(circularQueue.Rear());  // 返回 3
        System.out.println(circularQueue.isFull());  // 返回 true
        System.out.println(circularQueue.deQueue());  // 返回 true
        System.out.println(circularQueue.enQueue(4));  // 返回 true
        System.out.println(circularQueue.Rear());  // 返回 4
    }
}
