import java.io.*;
import java.util.Scanner;

public class IODemo13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要搜索的路径");
        String rootPath = scanner.next();
        System.out.println("请输入要查询的词");
        String word = scanner.next();

        File rootFile = new File(rootPath);
        if (!rootFile.isDirectory()) {
            System.out.println("输入的路径错误");
            return;
        }

        scanDir(rootFile, word);
    }

    private static void scanDir(File rootFile, String word) {
        File[] files = rootFile.listFiles();
        if (files==null) return;
        for (File f:
             files) {
            System.out.println("当前遍历到"+f.getAbsolutePath());
            if (f.isFile()) {
                if (searchFile(f, word)) {
                    System.out.println("找到了 "+f.getAbsolutePath());
                }
            } else if (f.isDirectory()) {
                scanDir(f, word);
            }
        }

    }

    private static boolean searchFile(File f, String word) {
        try (InputStream inputStream = new FileInputStream(f)){
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                byte[] buffer = new byte[1024];
                int n = inputStream.read(buffer);
                if (n==-1) break;
                String s = new String(buffer, 0, n);
                stringBuilder.append(s);
            }
            return stringBuilder.indexOf(word) != -1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
