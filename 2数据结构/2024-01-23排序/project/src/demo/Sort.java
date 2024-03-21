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
            gap = gap/3+1;
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
    /**
     * 选择排序
     * 时间复杂度: O(N^2)
     * 空间复杂度: O(1)
     * 稳定性: 不稳定
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            int j = i+1;
            for (; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (i!=minIndex) {
                swap(i, minIndex, arr);
            }
        }
    }
    public static void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void selectSort2(int[] arr) {
         int left  = 0;
         int right = arr.length-1;
         while (left<right) {
             int minIndex  = left;
             int maxIndex = right;
             for (int i = left; i <= right; i++) {
                 if (arr[i] < arr[minIndex]) {
                     minIndex = i;
                 }
                 if (arr[i] > arr[maxIndex]) {
                     maxIndex = i;
                 }
             }
             swap(minIndex, left,arr);
             if (maxIndex==left) {
                 maxIndex = minIndex;
             }
             swap(maxIndex, right,arr);
             left++;right--;
         }
    }

    /**
     *堆排序
     * 时间复杂度: O(N*logN)
     * 空间复杂度: O(1)
     * @param arr
     */
    public static void heapSort(int[] arr) {
        createHeap(arr);
        int end = arr.length-1;
        while (end>0) {
            swap(end, 0, arr);
            siftDown(arr, 0,end);
            end--;
        }
    }

    /**
     * 创建大根堆
     */
    public static void createHeap(int[] arr) {
        for (int parent = (arr.length-1-1)/2; parent >=0 ; parent--) {
            siftDown(arr, parent, arr.length);
        }
    }
    private static void siftDown(int[] arr, int parent, int end) {
        int child = parent*2+1;
        while (child<end) {
            if (child+1<end && arr[child+1]>arr[child]) {
                child++;
            }
            if (arr[child] > arr[parent]) {
                swap(child, parent, arr);
            } else {
                break;
            }
            parent = child;
            child = parent*2+1;
        }
    }

    /**
     * 冒泡排序
     * 时间复杂度:
     *      最好: O(N^2)
     *      最坏: O(N^2)
     * 稳定性: 稳定(取决于if语句加不加等号)
     * 优化: 使用标记flg 标记数组当前是否有序 如果有序了 直接退出循环
     * 优化后最好情况下时间复杂度O(N)
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            boolean flg = true;
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(j,j+1,arr);
                    flg = false;
                }
            }
            if (flg) {
                break;
            }
        }
    }
}
