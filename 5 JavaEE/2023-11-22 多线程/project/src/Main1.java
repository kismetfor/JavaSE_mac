public class Main1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        });
        t.start();
        Thread.sleep(3000);
        t.interrupt();

    }

}
