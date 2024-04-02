public class Main2 {

    public static void main(String[] args) {
        Thread t1 = new Thread(()-> {
            Thread t = Thread.currentThread();
            System.out.println(t.getName());
        });
        Thread t2 = new Thread(()-> {
            Thread t = Thread.currentThread();
            System.out.println(t.getName());
        });
        t1.start();
        t2.start();
    }
}
