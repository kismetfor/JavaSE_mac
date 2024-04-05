public class Main1 {
    public static void main(String[] args) {
        Object locker = new  Object();
        Thread t = new Thread(()->{
            synchronized (locker){
                synchronized (locker) {
                    System.out.println("----");
                }
            }
        });
        t.start();
    }
}
