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

    /**
     * 交换
     * @param i 交换
     * @param j 交换
     * @param arr 数组
     */
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
    /**
     * 快速排序
     * 时间复杂度: 最好情况下: O(logN)
     * 时间复杂度: 最坏情况下: O(N^2)
     * 空间复杂度:
     *  最好情况下: O(logN)
     *  最坏情况下: O(N)
     *  稳定性: 不稳定
     */
    public static void quickSort(int[] arr) {
        quick(arr, 0, arr.length-1);
    }
    public static void quick(int[] arr, int start, int end) {
        /*
        为什么这里面的if (start >= end) {
            return;
        }不可以写成if (start == end) {
            return;
        }原因在于，在快速排序的过程中，每次递归都会选取一个基准元素（pivot）并将数组分割为两部分，
        左侧是小于等于基准的元素，右侧是大于等于基准的元素。如果 start 和 end 相等，
        说明当前的子数组只包含一个元素，即已经是有序的。
        然而，if (start == end) 的条件可能在实际的分割过程中并不总是能够准确地捕获到需要停止的情况。
        这是因为在分割的过程中，可能会出现某些元素与基准相等的情况，
        导致在一次分割中有多个元素与基准相等，
        从而导致 start 和 end 在相等时，子数组并不是必然已经有序。
         */
        if (start >= end) {
            return;
        }

        int pivot = partitionHoare(arr, start, end);

        quick(arr, start, pivot-1);

        quick(arr, pivot+1, end);
    }

    /**
     * Hoare版
     * 分割--
     * 分治法
     * @param arr 数组
     * @param left 左
     * @param right 右
     * @return 中心点
     */
    public static int partitionHoare(int[] arr, int left, int right) {
        int tmp = arr[left];
        int p = left;
        while (left<right) {
            while (left<right && arr[right]>=tmp) {
                right--;
            }
            while (left<right && arr[left]<=tmp) {
                left++;
            }
            swap(left,right,arr);
        }
        swap(p,left,arr);
        return right;
    }

    /**
     * 挖坑法
     */
    public static int partition(int[] arr, int left, int right){
        int tmp = arr[left];
        while (left<right) {
            while (left<right && arr[right] >= tmp) {
                right--;
            }
            arr[left] = arr[right];
            while (left<right && arr[left] <= tmp) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[right] = tmp;
        return right;
    }
}
