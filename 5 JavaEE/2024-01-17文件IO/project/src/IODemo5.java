import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IODemo5 {
    public static void main(String[] args) throws IOException {
        try (InputStream inputStream = new FileInputStream("test.txt")){
            while (true) {
                byte[] buffer = new byte[1024];
                int n = inputStream.read(buffer);
                if (n==-1) break;
                String s = new String(buffer, 0, n);
                //此处构造 String 是通过前n个字节构造而不是整个数组.
                //实际读取文件的内容可能不足1024
                System.out.println(s);
            }
        }
    }
}
