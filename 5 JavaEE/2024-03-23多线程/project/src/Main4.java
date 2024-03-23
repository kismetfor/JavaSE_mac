public class Main4 {
    private static volatile boolean isRunning = true;
    public static void main(String[] args) {
        Thread t = new Thread(()-> {
            while (isRunning) {
                for (int i = 0; i < 1; i++) {
                    System.out.println("thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        t.setName("thread");
        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        isRunning = false;
    }
}
