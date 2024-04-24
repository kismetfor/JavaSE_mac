import java.io.File;
import java.util.Scanner;

public class IODemo12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入待查找文件名");
        String fileName = scanner.next();

        System.out.println("输入待查找路径");
        String rootDir = scanner.next();
        File root = new File(rootDir);
        if (!root.isDirectory()) {
            System.out.println("illegal");
            return;
        }

        find(fileName, root);
    }

    private static void find(String fileName, File root) {
        //当前目录中 所有的文件子目录都罗列出
        if (root == null) return;
        File[] files = root.listFiles();

        for (File f:
             files) {
            if (f.isFile()) {
                if (f.getName().equals(fileName)) {
                    System.out.println("find it! "+f.getAbsolutePath());
                    return;
                }
            }
             else if (f.isDirectory()) {
                find(fileName, f);
            }

        }
    }
}
