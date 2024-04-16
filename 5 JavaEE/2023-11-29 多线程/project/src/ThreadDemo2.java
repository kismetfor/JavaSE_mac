class Singleton {
    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
    private Singleton() {

    }
}
public class ThreadDemo2 {

    public static void main(String[] args) throws InterruptedException {
//        Singleton s = new Singleton();
        Singleton s = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s==s2);
    }
}
