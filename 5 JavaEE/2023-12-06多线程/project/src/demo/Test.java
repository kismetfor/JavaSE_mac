package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class MyThreadPollExecutor {
    private List<Thread> threadList = new ArrayList<>();
    private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1000);
    public MyThreadPollExecutor(int n) {
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(()->{
                while (true) {
                    try {
                        //此处take带有阻塞功能
                        //如果队列为空 阻塞到队列不为空为止
                        Runnable runnable = queue.take();
                        runnable.run();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
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
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPollExecutor executor = new MyThreadPollExecutor(4);
        for (int i = 0; i < 1000; i++) {
            int n = i;
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行任务"+ n +", 当前线程为: "+ Thread.currentThread().getName());
                }
            });
        }
    }
}
