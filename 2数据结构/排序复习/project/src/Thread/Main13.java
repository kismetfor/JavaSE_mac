package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Main13 {
    /**
     * 继承Thread 重写run方法
     */
    static class MyTread extends Thread {
        @Override
        public void run() {
            System.out.println("MyTread extends Thread");
        }
    }

    /**
     * 实现Runnable接口,重写run()方法
     * @param
     */
    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("MyRunnable implements Runnable");
        }
    }

    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("MyCallable implements Callable<Integer>");
            return 1;
        }
    }
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyCallable());
        new Thread(futureTask).start();
    }
}
