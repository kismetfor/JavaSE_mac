import java.io.File;
import java.io.IOException;

public class Main6 {
    public static void main(String[] args) throws IOException {
        File file = new File("old_name.txt");
        File newFile = new File("new_name.txt");

        System.out.println(newFile.delete());
        System.out.println(file.createNewFile());

        //rename
        boolean renamed = file.renameTo(newFile);
        System.out.println("重命名"+renamed);


    }

}
