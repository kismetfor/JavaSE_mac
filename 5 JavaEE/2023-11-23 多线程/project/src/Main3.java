import java.util.TreeMap;

public class Main3 {
    private static int count = 0;
    private static int count1 = 0;
    private static int count2 = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()-> {
            for (int i = 0; i < 50000; i++) {
                count1++;
            }
        });
        Thread t2 = new Thread(()-> {
            for (int i = 0; i < 50000; i++) {
                count2++;
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        count = count1+count2;
        System.out.println(count);
    }

}
