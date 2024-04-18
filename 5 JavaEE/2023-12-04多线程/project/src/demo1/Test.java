package demo1;

import java.util.PriorityQueue;

class MyTimerTask implements Comparable<MyTimerTask> {
    //在什么时间点来执行这个任务
    //此处的 ms级别的时间戳
    private long time;
    //实际任务要执行的代码
    //Runnable中提供了Run方法
    private Runnable runnable;

    //delay期望是一个相对时间
    public MyTimerTask(Runnable runnable, long delay) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + delay;
    }
    public void run() {
        runnable.run();
    }
    public long getTime() {
        return time;
    }
    @Override
    public int compareTo(MyTimerTask o) {
        return (int)(this.time - o.time);
    }
}

class MyTimer {
    final Object locker = new Object();
    //负责扫描任务队列 执行任务的线程
    private Thread t = null;

    //任务队列
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();
    public void schedule(Runnable runnable, long delay) {
        MyTimerTask task = new MyTimerTask(runnable, delay);
        synchronized (queue) {
            queue.offer(task);
            queue.notify();
        }
    }

    public MyTimer() {
        //构造方法 让扫描线程来完成判定和执行
        t = new Thread(()->{
           //扫描线程就需要反复的扫描队首元素 判断是否时间得当
            //如果时间不到 那就啥都不干
            //时间到了 就执行这个任务 并且把任务从队列中删除掉

            while (true) {
                //如果队列为空 就不可以取出来
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    MyTimerTask task = queue.peek();
                    //获取到当前时间
                    long curTime = System.currentTimeMillis();
                    assert task != null;
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
}
public class Test {
    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello timer 3000");
            }
        }, 3000);
         timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello timer 2000");
            }
        }, 2000);
         timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello timer 1000");
            }
        }, 1000);
        System.out.println("main");

    }
}
