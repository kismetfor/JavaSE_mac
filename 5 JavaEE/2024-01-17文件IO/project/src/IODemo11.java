import java.io.*;
import java.util.Scanner;

public class IODemo11 {
    public static void main(String[] args) {
        //实现文件复制~~
        //把一个文件复制一下,成为另一个文件.
        //把第一个文件读方式打开,依次读取出这里的每个字节，再把读到的内容，写入到另一个文件里~~
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要复制的源文件");
        String srcPath = scanner.next();
        System.out.println("请输入要复制的目标文件");
        String destPath = scanner.next();

        //合法性判断
        File srcFile = new File(srcPath);
        if (!srcFile.isFile()) {
            System.out.println("源文件没找到");
            return;
        }
        File destFile = new File(destPath);
        if (!destFile.getParentFile().isDirectory()) {
            System.out.println("目标文件路径错误");
            return;
        }

        try (InputStream inputStream = new FileInputStream(srcPath);
        OutputStream outputStream = new FileOutputStream(destFile)
        ){
            while (true) {
                byte[] buffer = new byte[1024];
                int n = inputStream.read(buffer);
                if (n==-1) break;
                outputStream.write(buffer, 0, n);
            }

        }  catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
