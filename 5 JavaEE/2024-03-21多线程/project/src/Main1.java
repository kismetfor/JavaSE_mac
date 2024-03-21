public class Main1 {
    static class MyThread extends Thread {
        @Override
        public void run(){
            while (true){
                System.out.println("hello Tread");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    System.out.println(e.getMessage());
//                }

            }
        }
    }
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
        while (true) {
            System.out.println("hello main");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.println(e.getMessage());
//            }
        }
    }
}
