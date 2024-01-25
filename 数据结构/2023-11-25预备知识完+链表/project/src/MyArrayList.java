import java.util.Arrays;

public class MyArrayList implements IList{
    public int[] elem;
    //作为常亮 默认值为0
    public int usedSize;
    //默认容量
    public static final int DEFAULT_CAPACITY = 5;
    //顺序表 添加方法
    public MyArrayList() {
        elem = new int[DEFAULT_CAPACITY];
    }

    @Override
    public void add(int data) {
        if (isFull()) {
            elem = Arrays.copyOf(elem, 2* elem.length);
        }
            elem[usedSize] = data;
            usedSize++;
    }

    @Override
    public void add(int pos, int data) {
        //pos合法 数组是否满了
        if (isFull()) {
            elem = Arrays.copyOf(elem, 2* elem.length);
        }
        for (int i = usedSize-1; i >= pos; i--) {
            elem[i+1] = elem[i];
        }
        elem[pos] = data;
        usedSize++;
    }
    private void checkPosOfAdd(int pos) {
        if (pos < 0 || pos>usedSize) {
            throw new PosException("pos位置为: " +pos);
        }
    }

    @Override
    public boolean contains(int toFind) {
        for (int i = 0; i < usedSize; i++) {
            if (toFind == elem[i]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(int toFind) {
        if (contains(toFind)) {
            for (int i = 0; i < usedSize; i++) {
                if (toFind == elem[i]) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int get(int pos) {
        //pos是否合法
        return 0;
    }

    @Override
    public void set(int pos, int value) {

    }

    @Override
    public void remove(int toRemove) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    //打印顺序表中所有的元素
    @Override
    public void display() {
        for (int i = 0; i < usedSize; i++) {
            System.out.print(elem[i]+" ");
        }
        System.out.println();
    }

    @Override
    public boolean isFull() {
        if (usedSize == elem.length) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
