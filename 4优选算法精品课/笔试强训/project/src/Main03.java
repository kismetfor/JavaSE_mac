import java.util.Scanner;
import java.util.Stack;

public class Main03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        Stack<Integer> minStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            if (a[i]%2==0) {
                minStack.push(a[i]);
            }
        }

    }
}
