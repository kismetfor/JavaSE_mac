public class Main4 {
    private static Object lock = new Object();
    private static Object lock2 = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(()-> {
            synchronized (lock) {
                System.out.println("t1获得lock");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    System.out.println("t1获得lock2");
                }
            }
        });
        Thread t2 = new Thread(()->{
            synchronized (lock2) {
                System.out.println("t2获得lock2");
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
