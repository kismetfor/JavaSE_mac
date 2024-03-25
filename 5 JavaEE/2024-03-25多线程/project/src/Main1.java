public class Main1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("start thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("thread end");
        });
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("start 1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(" end 1");
        });


        t.start();
        t1.start();

        t.join();
        for (int i = 0; i < 5; i++) {
            System.out.println("start main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("main end");
        t1.join();

    }
}
