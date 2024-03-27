public class Main7 {
    public static void main(String[] args) {
        // 使用匿名内部类创建线程，并实现了 Runnable 接口的 run 方法
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread using anonymous inner class");
            }
        });

        // 启动线程
        thread.start();
    }
}
