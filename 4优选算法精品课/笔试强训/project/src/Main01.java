import java.util.Scanner;

public class Main01 {
    //第一个字母放进字符串 或者直接输出
    //然后开始循环空格
    //如果有空格 那么输出i+1字符 并且 i多加一次跳过他
    //College English Test
    // Computer Science
    // I am Bob
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (Character.isLowerCase(s.charAt(0))) {
            System.out.print(Character.toUpperCase(s.charAt(0)));
        } else {
            System.out.print(s.charAt(0));
        }
        int i = 1;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                if (Character.isLowerCase(s.charAt(i+1))) {
                    System.out.print(Character.toUpperCase(s.charAt(i+1)));
                } else {
                    System.out.print(s.charAt(i+1));
                }
                i++;
            }
            i++;
        }
    }
}
