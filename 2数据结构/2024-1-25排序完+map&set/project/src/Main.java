import java.util.HashSet;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            func(str1, str2);
        }
    }
    public static void func(String str1, String str2) {
        HashSet<Character> set = new HashSet<>();
        int j = 0;
        for (char c:
             str2.toUpperCase().toCharArray()) {
            set.add(c);
        }
        HashSet<Character> setBroken = new HashSet<>();
        for (char c:
                str1.toUpperCase().toCharArray()) {
            if (!setBroken.contains(c) && !set.contains(c)) {
                setBroken.add(c);
                System.out.print(c);
            }
        }
    }
}