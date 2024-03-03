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
    public static void testInsertSort(int[] arr) {
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
    public static void testSelect2Sort(int[] arr) {
        int[] tmpArray = Arrays.copyOf(arr, 2* arr.length);
        long startTime = System.currentTimeMillis();
        Sort.selectSort2(tmpArray);
        long endTime = System.currentTimeMillis();
        System.out.println("选择排序2: " + (endTime-startTime));
    }

    public static void testShellSort(int[] arr) {
        int[] tmpArray = Arrays.copyOf(arr, 2* arr.length);
        long startTime = System.currentTimeMillis();
        Sort.shellSort(tmpArray);
        long endTime = System.currentTimeMillis();
        System.out.println("希尔排序: " + (endTime-startTime));
    }
    public static void testHeapSort(int[] arr) {
        int[] tmpArray = Arrays.copyOf(arr, 2* arr.length);
        long startTime = System.currentTimeMillis();
        Sort.heapSort(tmpArray);
        long endTime = System.currentTimeMillis();
        System.out.println("堆排序: " + (endTime-startTime));
    }
    public static void testQuickSort(int[] arr) {
        int[] tmpArray = Arrays.copyOf(arr, 2* arr.length);
        long startTime = System.currentTimeMillis();
        Sort.quickSort(tmpArray);
        long endTime = System.currentTimeMillis();
        System.out.println("快速排序: " + (endTime-startTime));
    }

    public static void main1(String[] args) {
        int[] arr = new int[10_0000];
        messArray(arr);
        //使用倒序排序到升序 考虑的是最坏时间复杂度
        testInsertSort(arr);
        testSelectSort(arr);
        testSelect2Sort(arr);
        testShellSort(arr);
        testHeapSort(arr);
        testQuickSort(arr);
    }

    public static void main(String[] args) {
//        int[] arr = {3,5,2,10,9,8,17};
        int[] arr = {2,1,4,3,5,9,8,6,5,7};
        Sort.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
