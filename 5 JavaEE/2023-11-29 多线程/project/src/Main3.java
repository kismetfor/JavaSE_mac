public class Main3 {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        // 线程1获取锁并执行耗时操作
        new Thread(() -> {
            try {
                // 模拟耗时操作
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(lock) {
                System.out.println("线程1获得了锁");
                try {
                    // 模拟耗时操作
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1释放了锁");
            }
        }).start();

        // 线程2尝试获取锁
        new Thread(() -> {
            try {
                // 模拟耗时操作
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(lock) {
                // 线程2无法获取锁，因为锁已被线程1持有
                System.out.println("线程2获得了锁");
            }
            System.out.println("线程2释放了锁");
        }).start();
    }
}
