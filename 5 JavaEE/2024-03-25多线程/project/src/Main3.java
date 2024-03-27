public class Main3 {
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("Hello Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();

    }
}
