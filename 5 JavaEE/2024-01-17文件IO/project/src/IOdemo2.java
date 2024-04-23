import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class IOdemo2 {
    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("./test.txt")) {
            inputStream.read();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main1(String[] args) throws IOException {
        InputStream inputStream = null;

        try {
            //从文件来读取 创建对象的过程，就是打开文件的过程
            inputStream = new FileInputStream("./test.txt");

        } finally {
            inputStream.close();

        }

    }
}
