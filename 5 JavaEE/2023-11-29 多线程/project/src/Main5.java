public class Main5 {
    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();

    public static void main(String[] args) {
        // 线程1持有资源1，请求资源2
        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("线程1持有资源1");
                try {
                    Thread.sleep(1000); // 为了确保线程2先持有资源2
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource2) {
                    System.out.println("线程1持有资源2");
                }
            }
        });

        // 线程2持有资源2，请求资源1
        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("线程2持有资源2");
                synchronized (resource1) {
                    System.out.println("线程2持有资源1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
