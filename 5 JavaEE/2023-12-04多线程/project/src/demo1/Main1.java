package demo1;

import java.util.Timer;
import java.util.TimerTask;

public class Main1 {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello timer 3000");
            }
        }, 3000);
        System.out.println("hello main");
        Thread.sleep(4000);
        timer.cancel();
    }
}
