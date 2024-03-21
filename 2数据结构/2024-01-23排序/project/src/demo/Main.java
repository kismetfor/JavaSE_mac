package demo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] arr = {3,5,2,10,9,8,17};
        int[] arr = {2,1,4,3,5,9,8,6,5,7};
        Sort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
