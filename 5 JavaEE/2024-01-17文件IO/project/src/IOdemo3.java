import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOdemo3 {
    public static void main(String[] args) throws IOException {
        try (InputStream inputStream = new FileInputStream("test.txt")) {
            StringBuilder word = new StringBuilder();
            while (true) {
                int n = inputStream.read();
                if (n == -1) {
                    // 文件读取完毕
                    break;
                }
                // 如果是字母，则拼接到单词中
                if (Character.isLetter((char) n)) {
                    word.append((char) n);
                } else {
                    // 遇到非字母字符，输出当前单词并清空
                    if (word.length() > 0) {
                        System.out.print(word+" ");
                        word.setLength(0);
                    }
                }
            }
            // 输出最后一个单词（如果有）
            if (word.length() > 0) {
                System.out.println(word);
            }
        }
    }
}
