import java.io.File;
import java.util.Scanner;

public class IODemo10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("搜索的文件名");
        String fileName = scanner.next();
        System.out.println("搜索的目录");
        String rootPath = scanner.next();
        File rootFile = new File(rootPath);
        if (!rootFile.isDirectory()) {
            System.out.println("输入的路径有误");
            return;
        }

        scanDir(rootFile, fileName);
    }

    private static void scanDir(File rootFile, String fileName) {
        //1.把当前目录中的所有文件和子目录都罗列出来
        File[] files = rootFile.listFiles();
        if (files==null) return;
        for (File f:
             files) {
            //普通文件 判定文件名是否是搜索的文件
            //是目录 就需要进一步递归
            System.out.println("当前遍历到"+f.getAbsolutePath());
            if (f.isFile()) {
                if (f.getName().equals(fileName)) {
                    System.out.println("find it! "+f.getAbsolutePath());
                    return;
                }
            } else if (f.isDirectory()){
                scanDir(f, fileName);
            }
        }
    }
}
