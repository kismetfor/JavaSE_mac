package demo;

public class Test {
    public static void main(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        testHeap.initElem(array);
        testHeap.creatHeap();
//        System.out.println(testHeap.poll());
        testHeap.offer(10);
        System.out.println("====");
    }
}
