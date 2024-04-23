import java.io.File;

public class Main5 {
    public static void main(String[] args) {
        File f = new File("./aaa");
        System.out.println(f.mkdirs());
    }
}
