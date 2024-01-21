import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6}};
        int[] array = {5,6,7};
        for (int x : array) {
            System.out.print(x+" ");
        }
        System.out.println();
        for (int[] arr1:arr) {
            for (int x:arr1) {
                System.out.print(x+" ");
            }
            System.out.println();
        }
        System.out.println(Arrays.deepToString(arr));
    }
}
