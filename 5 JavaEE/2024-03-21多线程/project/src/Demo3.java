public class Demo3 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            //匿名内部类
            @Override
            public void run() {
                    System.out.println("hello Thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
            }
        };
        while (true) {
            t.start();
        }
    }
}
