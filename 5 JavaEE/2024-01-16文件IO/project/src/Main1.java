import java.io.File;
import java.io.IOException;

public class Main1 {
    public static void main(String[] args) {
        // 创建文件
        File file = new File("example.txt");
        try {
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 删除文件
//        file.delete();

        // 重命名文件
        File newFile = new File("new_example.txt");
        file.renameTo(newFile);

        // 列出目录内容
        File directory = new File("/Users/rain/Desktop/就业课/5\\ JavaEE/2024-01-16文件IO/project");
        String[] files = directory.list();
        for (String fileName : files) {
            System.out.println(fileName);
        }
    }
    public static void main1(String[] args) {
        File file = new File("example.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        file.delete();

        File newFile = new File("new_example.txt");
        file.renameTo(newFile);
    }
}
