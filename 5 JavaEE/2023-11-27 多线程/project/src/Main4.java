public class Main4 {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        Thread t1 = new Thread(()-> {
            synchronized (a) {
                //sleep是为了留时间 让t1 t2线程都能拿到ab两个锁
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            //尝试获取B 没有释放a
            synchronized (b) {
                System.out.println("t1 two suo");
            }
        });
        Thread t2 = new Thread(()-> {
            synchronized (b) {
                //sleep是为了留时间 让t1 t2线程都能拿到ab两个锁
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            //尝试获取B 没有释放a
            synchronized (a) {
                System.out.println("t2 two suo");
            }
        });
        t1.start();
        t2.start();

    }
}
