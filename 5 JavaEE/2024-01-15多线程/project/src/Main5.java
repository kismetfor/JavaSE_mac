import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Main5 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            int id = i;
            Thread t = new Thread(()->{
                System.out.println("线程" + id + "开始下载");

                Random random = new Random();
                int n = (random.nextInt(5)+1)*1000;
                try {
                    Thread.sleep(n);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("线程" + id + "结束下载");

                latch.countDown();
            });
            t.start();
        }
        latch.await();
        System.out.println("所有任务完成");
    }
}
