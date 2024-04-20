import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static AtomicInteger count  = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                count.getAndIncrement();
            }

        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                count.getAndIncrement();
            }

        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count.get());
    }

}
