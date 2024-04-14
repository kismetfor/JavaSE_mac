// 互斥使用

public class Main2 {
    private static final Object lock = new Object();

    public static void criticalSection() {
        synchronized(lock) {
            System.out.println(Thread.currentThread().getName() + "进入临界区");
            // 这里是临界区，只有一个线程可以执行这段代码
            System.out.println(Thread.currentThread().getName() + "离开临界区");
        }
    }
    public static void criticalSection1() {
            System.out.println(Thread.currentThread().getName() + "进入临界区");
            System.out.println(Thread.currentThread().getName() + "离开临界区");
    }


    public static void main(String[] args) {
        new Thread(()->{try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
            criticalSection();
        }).start();
        new Thread(()->{try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
                    criticalSection();
                }).start();
    }

    public static void main1(String[] args) {
        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            criticalSection1();
        }).start();
        new Thread(()->{try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
            criticalSection1();
        }).start();
    }
}
