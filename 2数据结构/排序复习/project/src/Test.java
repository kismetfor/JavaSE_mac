import java.util.Arrays;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] arr = {5,3,4,7,2,8,6,9,1};
//        sort.insertSort(arr);
//        sort.shellSort(arr);
        sort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
