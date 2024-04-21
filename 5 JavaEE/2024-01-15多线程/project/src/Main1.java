public class Main1 {
    private static int sum = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int result = 0;
                for (int i = 1; i < 10000; i++) {
                    result += i;
                }
                sum += result;
            }
        });
        t.start();
        t.join();

        System.out.println(sum);
    }
}
