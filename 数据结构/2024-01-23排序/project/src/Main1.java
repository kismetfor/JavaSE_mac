import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
        int[] arr = {5,3,10,7,4};
        int temp;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            int j = i-1;
            for (; j >= 0 ; j--) {
                if (arr[j] > temp) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
