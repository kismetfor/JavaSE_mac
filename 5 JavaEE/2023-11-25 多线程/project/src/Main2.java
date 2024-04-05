class Test {
    public int count = 0;
    synchronized public void add() {
//        synchronized (this) {
//        synchronized (Test.class) {
            count++;
//        }
    }
    public void add2() {
        count++;
    }
}
public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        Test t = new Test();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 5000; i++) {

                t.add();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                t.add();
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(t.count);
    }
}
