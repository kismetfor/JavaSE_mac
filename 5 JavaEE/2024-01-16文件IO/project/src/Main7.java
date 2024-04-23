import java.io.File;
import java.io.IOException;

public class Main7 {
    public static void main(String[] args) throws IOException {
        File file = new File("old_name.txt");
        System.out.println(file.createNewFile()+"创建");
        //移动文件到新目录下并重命名
        File directory = new File("../");
        File movedFile = new File(directory, "new_name.txt");
        boolean moved = file.renameTo(movedFile);
        System.out.println("移动"+moved);
    }
}
