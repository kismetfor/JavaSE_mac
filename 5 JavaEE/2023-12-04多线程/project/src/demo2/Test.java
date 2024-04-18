package demo2;

import java.util.PriorityQueue;
import java.util.Queue;

class MyTimerTask implements Comparable<MyTimerTask>{
    private long time;

    private Runnable runnable;

    public MyTimerTask(Runnable runnable, long delay) {
        this.time = System.currentTimeMillis()+delay;
        this.runnable = runnable;
    }

    public void run() {
        runnable.run();
    }
    public long getTime() {
        return time;
    }

    @Override
    public int compareTo(MyTimerTask o) {
        return (int)(this.time-o.time);
    }
}
class MyTimer {
    private Thread t = null;
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();
    public void schedule(Runnable runnable, long delay) {
        MyTimerTask task = new MyTimerTask(runnable, delay);
        synchronized (queue) {
            queue.offer(task);
            queue.notify();
        }

    }
    public MyTimer() {
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
                   MyTimerTask task = queue.peek();
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
       t.start();
    }

    public void cancel() {
        t.interrupt();
    }
}
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyTimer timer = new MyTimer();
        //new的时候--调用构造方法 立即创建新的线程
        timer.schedule(()->{
            System.out.println("1000");
        }, 1000);
        timer.schedule(()->{
                    System.out.println("3000");
                }, 3000);
        timer.schedule(()->{
                    System.out.println("2000");
                }, 2000);

    }
}
