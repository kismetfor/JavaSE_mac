public class Main {

    private static Object lock = new Object();
    private static long count = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()-> {
            for (int i = 0; i < 50_0000; i++) {
                synchronized (lock) {
                    //进入大括号就会加锁
                    count++;
                }
                //出了大括号就会解锁

            }
        });
        Thread t2 = new Thread(()-> {
            for (int i = 50_0000; i < 100_0000; i++) {
                synchronized (lock) {
                    count++;
                }
            }
        });
        Thread t = new Thread(()-> {
            for (int i = 0; i < 100_0000; i++) {
                count++;
            }
        });
        long start = System.currentTimeMillis();

//        t.start();
//        t.join();

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(count);
    }
}
