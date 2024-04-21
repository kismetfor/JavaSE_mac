import java.util.concurrent.Semaphore;

public class Main3 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2);
        semaphore.acquire();
        System.out.println("P activity");
        semaphore.acquire();
        System.out.println("P activity");
        semaphore.acquire();
        System.out.println("P activity");

    }
}
