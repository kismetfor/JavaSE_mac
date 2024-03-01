package demo;

public class Sort {
    /**
     * 直接插入排序
     * 时间复杂度:
     *      最好: 数据有序的时候: O(N)
     *      最坏: 数据逆序的时候: O(N^2)
     * 空间复杂度: O(1)
     * 稳定性: 稳定
     * 如果if (arr[j] > tmp)  改为 >= 的话, 就是不稳定的排序
     * 一个稳定的排序, 可以变为不稳定的排序; 但是一个不稳定的排序, 无法变成一个稳定的排序
     * 特点: 数据越有序, 直接插入排序越快
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i-1;
            for (; j >=0 ; j--) {
                if (arr[j] > tmp) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = tmp;
        }
    }

    /**
     * 希尔排序
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int gap = arr.length;
        while (gap > 1) {
            gap = gap/3-1;
            shell(arr, gap);
        }
    }
    private static void shell(int[] arr, int gap) {
        for (int i = gap; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i-gap;
            for (; j >= 0; j-=gap) {
                if (arr[j]>tmp) {
                    arr[j+gap] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+gap] = tmp;
        }
    }
}
