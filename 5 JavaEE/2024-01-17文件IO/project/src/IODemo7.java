import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class IODemo7 {
    public static void main(String[] args) throws IOException {
//        使用字符流读取文件内容
        try (Reader reader = new FileReader("test.txt")){
            while (true) {
                char[] buffer = new char[1024];
                int n = reader.read(buffer);
                if (n == -1) break;
                String s = new String(buffer, 0, n);
                System.out.println(s);
            }
        }
    }
}
