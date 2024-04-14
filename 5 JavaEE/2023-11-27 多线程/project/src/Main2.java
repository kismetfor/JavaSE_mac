public class Main2 {
    public static void main(String[] args) {
        Thread t = new Thread(()-> {
           while (true) {
               System.out.println("Thread");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });
        t.start();
        while (true) {
            System.out.println("Main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
