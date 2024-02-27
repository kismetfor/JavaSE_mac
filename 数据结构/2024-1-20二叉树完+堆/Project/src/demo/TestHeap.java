package demo;

public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap() {
    }
    public void initElem(int[] array) {
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }
    }
    public void creatHeap() {

    }
}
