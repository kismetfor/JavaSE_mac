import java.util.Arrays;
/*稳定性:假定在待排序的记录序列中，
存在多个具有相同的关键字的记录，若经过排序，
这些记录的相对次序保持不变，即在原序列中，r[i]=r[j]，
且r[i]在r[j]之前，而在排序后的序列中，
[i仍在rj]之前，则称这种排序算法是稳定的;否则称为不稳定的。*/
public class Sort {
    /*
    * 插入排序
    * 时间复杂度: 最好情况下(全有序): O(N)
    * 最坏情况下(全倒序): O(N^2)
    * 空间复杂度: 没有开辟新的空间 O(1)
    * 稳定性: 稳定
    * 一个本身就不稳定的排序, 是不可能变为一个稳定的排序的
    * 但是一个本身稳定的排序, 能够加点变化变为不稳定的排序
    * 特点: 数据越有序, 时间复杂度越低
    * */
    public static void insertSort(int[] arr) {
        int temp;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            int j = i-1;
            for (; j >= 0 ; j--) {
                if (arr[j] > temp) {
                    //这里价格等于就是不稳定的排序了
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void shellSort(int[] arr) {
        int gap = arr.length;
        while (gap > 1) {
            gap /= 2;
            shell(arr, gap);
        }
    }
    public static void shell(int[] arr, int gap) {
        for (int i = gap; i < arr.length; i++) {
            //如果i+=gap的话, 就只能遍历其中一组
            //那么就+1, 交替遍历每一组
            int temp = arr[i];
            int j = i-gap;
            for (; j >=0 ; j-=gap) {
                if (temp < arr[j]) {
                    arr[j+gap] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+gap] = temp;
        }
    }

    public static void main(String[] args) {
//        int[] arr = {5,3,10,7,4};
        int[] arr = {9 , 1 , 2 , 5 , 7 , 4 , 8 , 6,  3,  5};
        Sort.shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
