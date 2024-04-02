public class Main1 {
    private static long result = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()-> {
            for (int i = 0; i < 500_0001; i++) {
                result += i;
            }
        });
        Thread t2 = new Thread(()-> {
            for (int i = 500_0001; i < 1000_0000; i++) {
                result += i;
            }
        });

        long start = System.currentTimeMillis();
        t.start();
        t2.start();

        t.join();
        t2.join();
        long end = System.currentTimeMillis();
        System.out.println(result);
        System.out.println(end-start);
    }
}
