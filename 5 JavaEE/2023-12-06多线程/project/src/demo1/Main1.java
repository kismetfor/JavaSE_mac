package demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class MyThreadPollExecutor {
    private List<Thread> threadList = new ArrayList<>();
    private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(5);
    public MyThreadPollExecutor(int n) {
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(()->{
                try {
                    Runnable runnable = queue.take();
                    runnable.run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            t.start();
            threadList.add(t);
        }
    }
    public void submit(Runnable runnable) throws InterruptedException {
        queue.put(runnable);
    }
}
public class Main1 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPollExecutor pollExecutor = new MyThreadPollExecutor(10);
        for (int i = 0; i < 10; i++) {
            int n = i;
            //可以不用加final 是事实变量
            pollExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行任务, "+ n + ", 当前线程为" + Thread.currentThread());
                }
            });
        }
    }
}
