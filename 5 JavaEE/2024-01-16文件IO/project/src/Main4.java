import java.io.File;
import java.util.Arrays;

public class Main4 {
    public static void main(String[] args) {
        File file = new File(".");
        //.表示当前目录
        String[] s = file.list();
        System.out.println(Arrays.toString(s));
    }
}
