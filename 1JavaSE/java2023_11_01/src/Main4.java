import java.util.Arrays;

public class Main4 {
    public static void main(String[] args) {
        int[] arr = fib(10);
        System.out.println(Arrays.toString(arr));
    }
    public static int[] fib(int n) {
        if (n <= 0) {
            return null;
        }
        int[] arr = new int[n];
        arr[0] = arr[1] = 1;
        for (int i=2; i<n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr;
    }
}
