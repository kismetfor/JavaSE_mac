public class Main1 {
    private static long count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()-> {
            for (int i = 0; i < 100_0000; i++) {
                count++;
            }
        });
        long start = System.currentTimeMillis();

        t.start();
        t.join();

        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(count);
    }
}
