public class ThreadDemo1 {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        Thread t1 = new Thread(()->{
            synchronized (object) {
                System.out.println("t1 wait begin");
                try {
                    //需要确保先执行wait 再执行notify
                    Thread.sleep(500000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("t1 wait end");
            }
        });
        Thread t2 = new Thread(()->{
            synchronized (object) {
                System.out.println("t2 notify begin");
                object.notify();
                System.out.println("t2 notify end");

            }
        });
        t1.start();
        t2.start();
    }
}
