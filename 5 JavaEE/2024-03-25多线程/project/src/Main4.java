public class Main4 {

    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("thread");
            }
        };
        t.start();
    }
}
