import java.io.File;

public class IOdemo3 {
    public static void main(String[] args) {
        File file = new File("./new_example.txt");
        File dest = new File("./aaa/bbb/ccc/new_new_example.txt");
        System.out.println(file.renameTo(dest));
    }
}
