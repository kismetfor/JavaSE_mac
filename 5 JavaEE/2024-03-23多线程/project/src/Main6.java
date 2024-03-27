public class Main6 {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println("Thread");
            }
        }.start();
    }
}
