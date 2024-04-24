import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class IODemo8 {
    public static void main(String[] args) throws IOException {
        try (Writer writer = new FileWriter("test.txt")){
            String s = "你好啊";
            writer.write(s);
        }
    }
}
