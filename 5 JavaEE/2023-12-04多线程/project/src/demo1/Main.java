package demo1;

import java.util.PriorityQueue;
class MyTimerTask1 implements Comparable<MyTimerTask1>{
    private long time;
    private Runnable runnable;
    public MyTimerTask1(Runnable runnable, long delay) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + delay;
    }
    public void run() {
        runnable.run();
    }
    @Override
    public int compareTo(MyTimerTask1 o) {
        return (int)(this.time-o.time);
    }

    public long getTime() {
        return time;
    }
}


class MyTimer1 {
    private Thread t = null;
    private PriorityQueue<MyTimerTask1> queue = new PriorityQueue<>();
    public void schedule(Runnable runnable, long delay) {
        MyTimerTask1 task = new MyTimerTask1(runnable, delay);
        synchronized (queue) {
            queue.offer(task);
            queue.notify();
        }

    }
    public MyTimer1() {
        t = new Thread(()->{

                while (true) {
                    synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    MyTimerTask1 task = queue.peek();
                    long curTime = System.currentTimeMillis();
                    if (curTime >= task.getTime()) {
                        queue.poll();
                        task.run();
                    } else {
                        try {
                            queue.wait(task.getTime()-curTime);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
            }
        });

    }
}
public class Main {
    public static void main(String[] args) {
        MyTimer1 timer1 = new MyTimer1();
        timer1.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("123");
            }
        }, 1000);
    }
}
