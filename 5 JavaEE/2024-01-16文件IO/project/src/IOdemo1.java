import java.io.File;

public class IOdemo1 {
    public static void main(String[] args) {
        File file = new File("./eee");
        System.out.println(file.mkdir());
    }
    public static void main1(String[] args) {
        File file = new File("./aaa/bbb/ccc");
        System.out.println(file.mkdirs());
    }
}
