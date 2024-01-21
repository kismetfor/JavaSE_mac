import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        func2(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void func1(int[] arr){
        arr = new int[]{11,22,33,44,55};
    }
    public static void func2(int[] arr){
        arr[0] = 99;
    }
}
