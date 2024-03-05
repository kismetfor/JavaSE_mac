import java.util.Stack;

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

        /*
        优化为三数取中
         */
        int index = middleNum(arr, start, end);
        swap(index, start, arr);
        int pivot = partition(arr, start, end);

        quick(arr, start, pivot-1);

        quick(arr, pivot+1, end);
    }
    public static int middleNum(int[] arr, int left, int right) {
        int mid = left + ((right-left) >> 1);
        if (arr[left] < arr[right]) {
            if (arr[right] < arr[mid]) {
                return right;
            } else if (arr[mid] <arr[left]) {
                return left;
            } else {
                return mid;
            }
        } else {
            if (arr[right] > arr[mid]) {
                return right;
            } else if (arr[mid] > arr[left]) {
                return left;
            } else {
                return mid;
            }
        }
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
    /**
     * 非递归快排
     */
    public static void quickSortNor(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        Stack<Integer> stack = new Stack<>();

        int index = middleNum(arr, left, right);
        swap(index, left, arr);
        int pivot = partition(arr, left, right);

        do {
            if (pivot-1 > left) {
                stack.push(left);
                stack.push(pivot-1);
            }
            if (pivot+1 < right) {
                stack.push(pivot+1);
                stack.push(right);
            }

            right = stack.pop();
            left = stack.pop();
            pivot = partition(arr, left, right);
        } while (!stack.isEmpty());
    }
    /**
     * 归并排序
     * 时间复杂度 O(logN)
     * 空间复杂度 O(N) 创建了一棵与数组相同大小的树
     *
     */
    public static void mergeSort(int[] arr) {
        mergeFunc(arr, 0, arr.length-1);
    }
    private static void mergeFunc(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left+((right-left)>>1);
        mergeFunc(arr, left, mid);
        mergeFunc(arr, mid+1, right);

        merge(arr, left, mid, right);
    }
    private static void merge(int[] arr, int left,int mid, int right) {
        int s1 = left;
        int e1 = mid;
        int s2 = mid+1;
        int e2 = right;

        int[] tmpArr = new int[right-left+1];
        int k = 0;
        while (s1<=e1 && s2<=e2) {
            if (arr[s1] <= arr[s2]) {
                tmpArr[k++] = arr[s1++];
            } else {
                tmpArr[k++] = arr[s2++];
            }
        }
        while (s1<=e1) {
            tmpArr[k++] = arr[s1++];
        }
        while (s2<=e2) {
            tmpArr[k++] = arr[s2++];
        }
        for (int i = 0; i < k; i++) {
            arr[i+left] = tmpArr[i];
        }
    }
    /**
     * 非递归归并
     */
    public static void mergeSortNor(int[] arr) {
        int gap = 1;
        while (gap < arr.length) {
            for (int i = 0; i < arr.length; i+=2*gap) {
                int left = i;
                int mid = left+gap-1;
                if (mid>= arr.length) {
                    mid = arr.length-1;
                }

                int right = mid+gap;
                if (right>= arr.length) {
                    right = arr.length-1;
                }
                merge(arr, left, mid,right);
            }
            gap*= 2;
        }
    }
    public static void countSort(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i=1; i< arr.length;i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int[] count = new int[max-min+1];
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i]-min;
            count[index]++;
        }
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            while (count[i]-- != 0) {
                arr[k++] = count[i];
            }
        }
    }
}
