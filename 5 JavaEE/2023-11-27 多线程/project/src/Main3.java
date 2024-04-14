
class MyLock {
    private boolean locked = false;

    public synchronized void lock() {
        if (locked) {
            // 如果已经被锁定，当前线程会被阻塞
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        locked = true;
    }

    public synchronized void unlock() {
        locked = false;
        notify();
    }
}

class MyThread extends Thread {
    private MyLock lock;

    public MyThread(MyLock lock) {
        this.lock = lock;
    }

    public void run() {
        lock.lock();
        System.out.println("线程 " + Thread.currentThread().getId() + " 获取了锁");
        // 如果再次尝试获取锁
        lock.lock(); // 这里会导致死锁
        System.out.println("线程 " + Thread.currentThread().getId() + " 再次获取了锁");
        lock.unlock();
    }
}

public class Main3 {
    public static void main(String[] args) {
        MyLock lock = new MyLock();
        MyThread thread1 = new MyThread(lock);
        thread1.start();
    }
}

