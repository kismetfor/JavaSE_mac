import java.io.File;

public class IOdemo2 {
    public static void main(String[] args) {
        File file = new File("new_name.txt");
        File dest = new File("new_new_name.txt");
        System.out.println(file.renameTo(dest));
    }
}
