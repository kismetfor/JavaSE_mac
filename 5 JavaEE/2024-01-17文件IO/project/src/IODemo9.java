import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class IODemo9 {
    public static void main(String[] args) throws IOException {
        try (InputStream inputStream = new FileInputStream("test.txt")){
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNext()) {
                String s = scanner.next();
                System.out.println(s);
            }
        }
    }
}
