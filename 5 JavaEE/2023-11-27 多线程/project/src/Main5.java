import java.util.Scanner;

public class Main5 {
    private volatile static int flag = 0;
    public static void main(String[] args) {
        Thread t1 = new Thread(()-> {
            while (flag == 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("t1结束");
        });
        Thread t2 = new Thread(()-> {
            System.out.println("输入flag");
            Scanner scanner = new Scanner(System.in);
            flag = scanner.nextInt();
        });
        t1.start();
        t2.start();
    }
}
