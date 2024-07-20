public class Sort {
    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /***
     * 插入排序
     * @param arr
     */
    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i-1;
            for ( ; j >= 0; j--) {
                if (arr[j] > tmp) {
                    swap(arr,j,j+1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 希尔排序
     * @param arr
     */
    public void shellSort(int[] arr) {
        int gap = arr.length;
        while (gap > 1) {
            gap = gap/3+1;
            shell(arr,gap);
        }
    }
    public void shell(int[] arr, int gap) {
        for (int i = gap; i < arr.length; i+=gap) {
            int tmp = arr[i];
            int j = i-gap;
            for ( ; j >= 0; j-=gap) {
                if (arr[j] > tmp) {
                    swap(arr,j,j+gap);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 冒泡排序 明天写一下优化和博客
     * @param arr
     */
    public void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = arr.length-1; j >= i; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(arr,j,j-1);
                }
            }
        }
    }
    /**
     * 归并排序
     */
    public void mergeSort(int[] arr) {

    }
    public void mergeFunc(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right-left)>>1;
        mergeFunc(arr, left, mid);
        mergeFunc(arr, mid, right);


    }
    public void merge(int[] arr, int left, int mid, int right) {
        int s1 = left;
        int e1 = mid;
        int s2 = mid+1;
        int e2 = right;

        int[] tmpArr = new int[right-left+1];
    }
}
