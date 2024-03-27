
class MyThread extends Thread{
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
public class Main2 {
    public static void main(String[] args) {
        MyThread t = new MyThread();
//        t.start(); 并发
//        t.run(); 串行
        while (true) {
            System.out.println("Hello Main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
