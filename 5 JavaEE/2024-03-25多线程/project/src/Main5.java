public class Main5 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println("thread");
        });
        t.start();
    }
}
