public class Main3 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for (int i = 0; i < 1; i++) {
                System.out.println("thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
            }
        });
        t.setName("myThread");
        t.setDaemon(true);
        t.start();
        while (true) {
            System.out.println("main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
