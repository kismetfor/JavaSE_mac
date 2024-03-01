package demo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3,5,2,10,9,8,17};
        Sort.shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
