import java.util.Scanner;

public class Main02 {
    static class minLength {
        int length;
        int start;
        int end;

        public minLength(int x) {
            length = x;
            start = 0;
            end = x-1;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int left = 0;
        int right = 0;
        int sum = a[right];
        minLength minL = new minLength(n);

        while (right < n-1) { //后续修改条件
            while (sum < x && right < n-1) { //进窗口
                sum += a[++right];
            }

            while (left <= right && sum >= x) { //出窗口
                if (right-left+1 < minL.length) { //记录
                    minL.length = right-left+1;
                    minL.start = left + 1;
                    minL.end = right + 1;
                }
                sum -= a[++left];
            }
        }
        while (left <= right && sum >= x) { //出窗口
            if (right-left+1 < minL.length) { //记录
                minL.length = right-left+1;
                minL.start = left + 1;
                minL.end = right + 1;
            }
            sum -= a[++left];
        }
        System.out.println(minL.start+" "+ minL.end);
    }
}
