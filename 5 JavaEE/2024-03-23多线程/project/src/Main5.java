public class Main5 {
    public static void main(String[] args) {
        Thread t = new Thread(()-> {
            while (!Thread.currentThread().isInterrupted()) {
                for (int i = 0; i < 100; i++) {
                    System.out.println("thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "自定义线程");
        t.setName("MyThread");
        t.start();
        System.out.println(t.isInterrupted());
        t.interrupt();
    }
}
