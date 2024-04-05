import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread 1: First lock");
                // 在持有锁的情况下再次获取锁
                lock.lock();
                try {
                    System.out.println("Thread 1: Nested lock");
                } finally {
                    lock.unlock();
                }
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread 2: First lock");
            } finally {
                lock.unlock();
            }
        }).start();
    }
}
