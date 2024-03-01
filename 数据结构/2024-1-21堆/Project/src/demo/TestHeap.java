package demo;

import java.util.Arrays;

public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap() {
    }
    public void initElem(int[] array) {
        elem = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }
    }
    public void creatHeap() {
        for (int parent = (usedSize-1-1)/2; parent >=0; parent--) {
            siftDown(parent);
        }
    }

    /**
     * 树的节点个数为n
     * 具有n个结点的完全二叉树的深度k为log2(n＋1）上取整
     * 时间复杂度为O(log2n) 因为最坏情况下 树的每一个节点都需要遍历
     * @param parent
     */
    public void siftDown(int parent) {
        int child = parent*2+1;
        while (child<usedSize) {
            if (child+1<usedSize && elem[child]<elem[child+1]) {
                child++;
            }
            if (elem[child]>elem[parent]) {
                swap(child, parent);
                parent = child;
                child = parent*2+1;
            } else {
                break;
            }
        }
    }
    public void siftDown(int parent, int end) {
        int child = parent*2+1;
        while (child<end) {
            if (child+1<end && elem[child]<elem[child+1]) {
                child++;
            }
            if (elem[child]>elem[parent]) {
                swap(child, parent);
                parent = child;
                child = parent*2+1;
            } else {
                break;
            }
        }
    }
    public void swap(int i, int j) {
        int temp = elem[i];
        elem[i] = elem[j];
        elem[j] = temp;
    }

    /**
     * 删除函数 返回删除的值
     */
    public int poll() {
        if (isEmpty()) {
            return -1;
        }
        int tmp = elem[0];
        swap(0, usedSize-1);
        usedSize--;
        siftDown(0);
        return tmp;
    }
    public boolean isEmpty() {
        return usedSize == 0;
    }
    public boolean isFull() {
        return usedSize == elem.length;
    }
    public void offer(int val) {
        if (isFull()) {
            elem = Arrays.copyOf(elem, 2* elem.length);
        }
        elem[usedSize] = val;
        usedSize++;
        siftUp(usedSize-1);
    }
    public void siftUp(int child) {
        int parent = (child-1)/2;
        while (child > 0) {
            if (elem[child]>elem[parent]) {
                swap(child, parent);
                child = parent;
                parent = (child-1)/2;
            } else {
                break;
            }
        }
    }

    /**
     * 堆排序 从小到大进行排序
     * 这里是大根堆
     */
    public void heapSort() {
        int end = usedSize-1;
        while (end > 0) {
            swap(end, 0);
            siftDown(0, end-1);
            end--;
        }
    }
}
