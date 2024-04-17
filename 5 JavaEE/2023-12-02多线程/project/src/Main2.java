
class MyBlockingQueue {
    final Object locker = new Object();
    private String[] elems;
    private int size;
    private int head;
    private int tail;

    public MyBlockingQueue(int capacity) {
        elems = new String[capacity];
    }
    public void put(String elem) throws InterruptedException {
        synchronized (locker) {
            //使用 wait 的时候，要搭配 while循环，进行条件判定，
            //wait之前，需要先判定条件是否满足. wait唤醒之后,也需要再确认一次.
            while (size >= elems.length) {
                //这里使用while而不是if的原因是 if只能判断一次 while当条件成立的时候会判断无数次 知道不符合条件
                //因为 这里的wait可能会被另一个进程的notify唤醒 因为notify唤醒是随机的 可能是take唤醒 也可能是另一个进程的put唤醒
                //如果是另一个put唤醒的话 就会导致这里size明明满了 但是却唤醒了wait继续put元素
                locker.wait();
            }
            elems[tail++] = elem;
            size++;
            tail %= elems.length;
            locker.notify();
        }
    }

    public String take() throws InterruptedException {
        String elem = null;
        synchronized (locker) {
            while (size==0) {
                locker.wait();
            }
            elem = elems[head++];
            head %= elems.length;
            size--;
            locker.notify();
        }
        return elem;
    }


}

public class Main2 {
    public static void main(String[] args) {
        MyBlockingQueue queue = new MyBlockingQueue(2);
        Thread producer = new Thread(()->{
            int n = 1;
            while (true) {
                try {
                    System.out.println("生产者放入"+n);
                    queue.put(Integer.toString(n));
                    n++;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread conductor = new Thread(()->{
            while (true) {
                try {
                    String elem = queue.take();
                    System.out.println("消费者消费"+elem);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        producer.start();
        conductor.start();
    }
}