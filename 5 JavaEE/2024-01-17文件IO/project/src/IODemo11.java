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

        

    }
}
