import java.io.File;
import java.io.IOException;

public class Main3 {
    public static void main(String[] args) throws InterruptedException, IOException {
        File file = new File("test.txt");
        System.out.println(file.createNewFile());
        file.deleteOnExit();
        Thread.sleep(3000);
//        System.out.println(file.delete());
    }
}
