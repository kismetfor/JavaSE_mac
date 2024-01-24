import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void inorderArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }
    public static void notInorderArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr.length-i;
        }
    }
    public static void messArray(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(arr.length);
        }
    }
    public static void testInserSort(int[] arr) {
        int[] tmpArray = Arrays.copyOf(arr, 2* arr.length);
        long startTime = System.currentTimeMillis();
        Sort.insertSort(tmpArray);
        long endTime = System.currentTimeMillis();
        System.out.println("插入排序: " + (endTime-startTime));
    }
    public static void testSelectSort(int[] arr) {
        int[] tmpArray = Arrays.copyOf(arr, 2* arr.length);
        long startTime = System.currentTimeMillis();
        Sort.selectSort(tmpArray);
        long endTime = System.currentTimeMillis();
        System.out.println("选择排序: " + (endTime-startTime));
    }

    public static void testShellSort(int[] arr) {
        int[] tmpArray = Arrays.copyOf(arr, 2* arr.length);
        long startTime = System.currentTimeMillis();
        Sort.shellSort(tmpArray);
        long endTime = System.currentTimeMillis();
        System.out.println("希尔排序: " + (endTime-startTime));
    }

    public static void main(String[] args) {
        int[] arr = new int[10_0000];
//        notInorderArray(arr);
        //使用倒序排序到升序 考虑的是最坏时间复杂度
        inorderArray(arr);
        testInserSort(arr);
        testSelectSort(arr);
        testShellSort(arr);
    }
}
