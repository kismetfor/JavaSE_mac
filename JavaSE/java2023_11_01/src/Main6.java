import java.util.Arrays;

public class Main6 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        //拷贝arr这个数组, 长度为3
        int[] copy = Arrays.copyOf(arr, 3);
        System.out.println(Arrays.toString(copy));
        //拷贝arr这个数组, 新的长度为arr.length*2
        //相当于扩容了
        //arr指向的是新的空间
        arr = Arrays.copyOf(arr, arr.length*2);
        System.out.println(Arrays.toString(arr));
    }
    public static void main1(String[] args) {
        //数组拷贝
        int[] arr = {1,2,3,4};
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        System.out.println(Arrays.toString(copy));
    }
}
